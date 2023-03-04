package com.edmund.PandaPlate.service;

import com.edmund.PandaPlate.Pojo.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edmund.PandaPlate.dto.DishDto;
import com.edmund.PandaPlate.dto.SetmealDto;

/**
* @author edmundxie
* @description 针对表【setmeal(套餐)】的数据库操作Service
* @createDate 2023-02-26 23:22:47
*/
public interface SetmealService extends IService<Setmeal> {
    public void saveWithDishes(SetmealDto setmealDto);

    //根据id查询菜品，用于页面显示与回显
    public SetmealDto getByIdWithDishes(Long id);

    //根据id更新菜品
    public void updateWithDishes(SetmealDto setmealDto);

    //根据id删除菜品
    public void deleteByIdWithDishes(Long id);
}
