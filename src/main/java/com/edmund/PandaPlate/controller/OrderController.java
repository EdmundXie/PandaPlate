package com.edmund.PandaPlate.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edmund.PandaPlate.Pojo.OrderDetail;
import com.edmund.PandaPlate.Pojo.Orders;
import com.edmund.PandaPlate.Pojo.ShoppingCart;
import com.edmund.PandaPlate.common.BaseContext;
import com.edmund.PandaPlate.common.R;
import com.edmund.PandaPlate.dto.OrderDto;
import com.edmund.PandaPlate.service.OrderDetailService;
import com.edmund.PandaPlate.service.OrdersService;
import com.edmund.PandaPlate.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Projectname: PandaPlate
 * @Filename: OrderController
 * @Author: EdmundXie
 * @Data:2023/3/3 21:06
 * @Email: 609031809@qq.com
 * @Description:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    //用户下单
    @PostMapping("/submit")
    public R<String> submitOrder(@RequestBody Orders orders, HttpSession session){
        //设置基本信息以及下单时间
        Long curId = (Long) session.getAttribute("user");
        if(curId==null){
            return R.error("用户未登录");
        }

        ordersService.submit(orders,curId);
        return R.success("下单成功");
    }

    //分页查询订单
    @GetMapping("/userPage")
    @Transactional
    public R<Page> getPage(int page,int pageSize,HttpSession session){
        //Create initial page
        Page<Orders> ordersPage = new Page<>(page,pageSize);
        Page<OrderDto> orderDtoPage = new Page<>(page,pageSize);

        //build query wrapper
        LambdaQueryWrapper<Orders> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Orders::getUserId,session.getAttribute("user"));
        wrapper.orderByDesc(Orders::getCheckoutTime);
        ordersService.page(ordersPage,wrapper);

        //copy page except records
        BeanUtils.copyProperties(ordersPage,orderDtoPage,"records");

        //rebuild records
        List<Orders> oriRecords = ordersPage.getRecords();
        List<OrderDto> newRecords = oriRecords.stream().map(item ->{
            OrderDto orderDto = new OrderDto();

            BeanUtils.copyProperties(item,orderDto);
            //get all orderDetails from order_detail table
            LambdaQueryWrapper<OrderDetail> wp = new LambdaQueryWrapper<>();
            wp.eq(OrderDetail::getOrderId,item.getId());
            List<OrderDetail> orderDetails = orderDetailService.list(wp);

            orderDto.setOrderDetails(orderDetails);
            return orderDto;

        }).collect(Collectors.toList());

        orderDtoPage.setRecords(newRecords);
        return R.success(orderDtoPage);
    }

    //管理端分页查询订单
    @GetMapping("/page")
    public R<Page> backendPage(int page,int pageSize,String number,String beginTime,String endTime){
        //Create initial page
        Page<Orders> ordersPage = new Page<>(page,pageSize);
        LambdaQueryWrapper<Orders> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(number),Orders::getNumber,number);

        LocalDateTime now = LocalDateTime.now();


        if(beginTime!=null&&endTime!=null){
            wrapper.ge(Orders::getOrderTime,beginTime);
            wrapper.le(Orders::getOrderTime,endTime);
        }
        wrapper.orderByDesc(Orders::getCheckoutTime);
        ordersService.page(ordersPage,wrapper);

        //set userName
        ordersPage.getRecords().forEach(orders -> {
            orders.setUserName("用户"+orders.getUserId().toString());
        });
        return R.success(ordersPage);
    }

    //修改订单状态
    @PutMapping()
    public R<String> update(@RequestBody Orders orders){
        LambdaUpdateWrapper<Orders> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(orders.getId()!=null,Orders::getId,orders.getId());
        wrapper.set(Orders::getStatus,orders.getStatus());
        ordersService.update(wrapper);
        return R.success("派送成功");
    }

    //再来一单
    @PostMapping("/again")
    @Transactional
    public R<String> orderAgain(@RequestBody Orders orders){
        Long curId = orders.getId();
        //根据order的id查到所有orderDetails
        LambdaQueryWrapper<OrderDetail> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderDetail::getOrderId,orders.getId());
        List<OrderDetail> orderDetails = orderDetailService.list(wrapper);

        if(orderDetails==null||orderDetails.isEmpty()){
            return R.error("再来一单失败，未查询到订单");
        }

        //将所有orderDetails，复制给shoppingCart
        orderDetails.forEach(orderDetail -> {
            ShoppingCart shoppingCart = new ShoppingCart();
            BeanUtils.copyProperties(orderDetail,shoppingCart,"orderId");
            shoppingCart.setUserId(BaseContext.getCurrentId());
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.save(shoppingCart);
        });

        return R.success("再来一单成功");
    }
}
