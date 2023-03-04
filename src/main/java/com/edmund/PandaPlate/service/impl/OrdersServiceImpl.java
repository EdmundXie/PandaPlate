package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.*;
import com.edmund.PandaPlate.common.CustomException;
import com.edmund.PandaPlate.service.*;
import com.edmund.PandaPlate.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
* @author edmundxie
* @description 针对表【orders(订单表)】的数据库操作Service实现
* @createDate 2023-03-03 21:04:38
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressBookService addressBookService;

    @Override
    @Transactional
    public void submit(Orders orders, Long userId) {

        //查询购物车数据

        AtomicReference<BigDecimal> amount = new AtomicReference<>(new BigDecimal(0));
        LambdaQueryWrapper<ShoppingCart> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ShoppingCart::getUserId,userId);
        List<ShoppingCart> list =shoppingCartService.list(wrapper);
        if(list==null||list.size()==0){
            throw new CustomException("购物车为空，无法下单");
        }
        //查询用户数据
        User user = userService.getById(userId);
        //查询地址数据
        AddressBook addressBook = addressBookService.getById(orders.getAddressBookId());
        if(addressBook==null){
            throw new CustomException("用户地址有误，无法下单");
        }

        Long orderId = IdWorker.getId();//生成订单号
        //向orderDetail表插多条数据
        //order_id,name,image,dish_id/setmeal_id,dish_flavor,numberm,amount
        List<OrderDetail> orderDetails = new ArrayList<>();
        list.forEach(item -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setNumber(item.getNumber());
            orderDetail.setDishFlavor(item.getDishFlavor());
            orderDetail.setDishId(item.getDishId());
            orderDetail.setSetmealId(item.getSetmealId());
            orderDetail.setName(item.getName());
            orderDetail.setImage(item.getImage());
            orderDetail.setAmount(item.getAmount());

            //设置订单金额
            amount.updateAndGet(v -> v.add(item.getAmount()));
            orderDetails.add(orderDetail);
        });


        //向order表插入一条数据
        //phone,address,user_name,consignee
        orders.setId(orderId);
        orders.setNumber(String.valueOf(orderId));
        orders.setUserId(userId);
        orders.setStatus(2);
        orders.setOrderTime(LocalDateTime.now());
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setAmount(amount.get());
        orders.setUserName(user.getName());
        orders.setConsignee(addressBook.getConsignee());
        orders.setPhone(user.getPhone());
        orders.setAddress((addressBook.getProvinceName()==null?"":addressBook.getProvinceName())
                +(addressBook.getCityName()==null?"":addressBook.getCityName())
                +(addressBook.getDistrictName()==null?"":addressBook.getDistrictName())
                +(addressBook.getDetail()==null?"":addressBook.getDetail()));

        orderDetailService.saveBatch(orderDetails);
        this.save(orders);

        //清空购物车数据
        shoppingCartService.remove(wrapper);
    }
}




