package com.edmund.PandaPlate.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edmund.PandaPlate.Pojo.Dish;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edmund.PandaPlate.dto.DishDto;

/**
* @author edmundxie
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2023-02-26 23:22:40
*/
public interface DishService extends IService<Dish> {

    //需要操作dish和dishflavor表

    //新增菜品，同时插入菜品的口味
    public void saveWithFlavor(DishDto dishdto);

    //根据id查询菜品，用于页面显示与回显
    public DishDto getByIdWithFlavor(Long id);

    //根据id更新菜品
    public void updateWithFlavor(DishDto dishDto);

    //根据id删除菜品
    public void deleteByIdWithFlavor(Long id);
}
