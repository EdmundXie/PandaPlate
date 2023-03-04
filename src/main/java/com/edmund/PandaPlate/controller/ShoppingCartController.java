package com.edmund.PandaPlate.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.edmund.PandaPlate.Pojo.ShoppingCart;
import com.edmund.PandaPlate.common.R;
import com.edmund.PandaPlate.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Projectname: PandaPlate
 * @Filename: ShoppingCartController
 * @Author: EdmundXie
 * @Data:2023/3/3 15:20
 * @Email: 609031809@qq.com
 * @Description:
 */
@RestController
@RequestMapping("/shoppingCart")
@Slf4j
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;


    //添加菜品或套餐到购物车
    @PostMapping("/add")
    public R<ShoppingCart> addItem(@RequestBody ShoppingCart shoppingCart, HttpSession session){
        //设定当前用户id
        shoppingCart.setUserId((Long) session.getAttribute("user"));
        LambdaQueryWrapper<ShoppingCart> wrapper = new LambdaQueryWrapper<>();

        //判断购物车中是套餐还是菜品
        if(shoppingCart.getDishId()!=null){
            wrapper.eq(ShoppingCart::getDishId,shoppingCart.getDishId());
        }
        else if(shoppingCart.getSetmealId()!=null){
            wrapper.eq(ShoppingCart::getSetmealId,shoppingCart.getSetmealId());
        }

        //判断当前菜品是否已经加入购物车
        ShoppingCart one = shoppingCartService.getOne(wrapper);

        //设定数量
        //如果已加入当前菜品
        if(one!=null){
            one.setNumber(one.getNumber()+1);
            shoppingCartService.updateById(one);
            return R.success(one);
        }
        //未加入当前菜品或口味不同
        shoppingCart.setNumber(1);
        shoppingCart.setCreateTime(LocalDateTime.now());
        shoppingCartService.save(shoppingCart);
        return R.success(shoppingCart);
    }

    //从购物车删除
    @PostMapping("/sub")
    public R<ShoppingCart> subItem(@RequestBody ShoppingCart shoppingCart){

        //查询该菜品的购物车记录
        LambdaQueryWrapper<ShoppingCart> wrapper = new LambdaQueryWrapper<>();

        //判断购物车中是套餐还是菜品
        if(shoppingCart.getDishId()!=null){
            wrapper.eq(ShoppingCart::getDishId,shoppingCart.getDishId());
        }
        else if(shoppingCart.getSetmealId()!=null){
            wrapper.eq(ShoppingCart::getSetmealId,shoppingCart.getSetmealId());
        }

        ShoppingCart one = shoppingCartService.getOne(wrapper);
        int number = one.getNumber();
        //如果记录等于0，不操作
        if(number==1){
            shoppingCartService.remove(wrapper);
            one.setNumber(0);
        }
        else {//如果记录大于1，记录的number--；
            one.setNumber(number-1);
            shoppingCartService.updateById(one);
        }
        return R.success(one);
    }

    //查看购物车
    @GetMapping("/list")
    public R<List<ShoppingCart>> getList(HttpSession session){
        Long curId = (Long) session.getAttribute("user");

        LambdaQueryWrapper<ShoppingCart> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(curId!=null,ShoppingCart::getUserId,curId);
        wrapper.orderByDesc(ShoppingCart::getCreateTime);
        List<ShoppingCart> list = shoppingCartService.list(wrapper);

        return R.success(list);
    }

    //清空购物车
    @DeleteMapping("/clean")
    public R<String> clean(HttpSession session){
        Long curId = (Long) session.getAttribute("user");
        LambdaQueryWrapper<ShoppingCart> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(curId!=null,ShoppingCart::getUserId,curId);

        shoppingCartService.remove(wrapper);
        return R.success("清除购物车成功");
    }
}
