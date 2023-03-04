package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.Category;
import com.edmund.PandaPlate.Pojo.Dish;
import com.edmund.PandaPlate.Pojo.Setmeal;
import com.edmund.PandaPlate.common.CustomException;
import com.edmund.PandaPlate.service.CategoryService;
import com.edmund.PandaPlate.mapper.CategoryMapper;
import com.edmund.PandaPlate.service.DishService;
import com.edmund.PandaPlate.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author edmundxie
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
* @createDate 2023-02-26 12:08:21
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    //根据id删除分类，删除之前需要判断
    @Override
    public void remove(Long id) {
        //查询当前分类是否关联了菜品，如果已关联，抛异常
        LambdaQueryWrapper<Dish> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dish::getCategoryId,id);
        int countDish = dishService.count(wrapper);
        if(countDish>0){
            throw new CustomException("改分类有关联菜品");
        }
        //查询当前分类是否关联了套餐，如果已关联，抛异常
        LambdaQueryWrapper<Setmeal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int countSetmeal = setmealService.count(lambdaQueryWrapper);
        if(countSetmeal>0){
            throw new CustomException("改分类有关联套餐");
        }

        //未关联直接删除
        this.removeById(id);
    }
}




