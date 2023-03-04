package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.Dish;
import com.edmund.PandaPlate.Pojo.DishFlavor;
import com.edmund.PandaPlate.Pojo.Setmeal;
import com.edmund.PandaPlate.Pojo.SetmealDish;
import com.edmund.PandaPlate.dto.DishDto;
import com.edmund.PandaPlate.dto.SetmealDto;
import com.edmund.PandaPlate.service.SetmealDishService;
import com.edmund.PandaPlate.service.SetmealService;
import com.edmund.PandaPlate.mapper.SetmealMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
* @author edmundxie
* @description 针对表【setmeal(套餐)】的数据库操作Service实现
* @createDate 2023-02-26 23:22:47
*/
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal>
    implements SetmealService{

    @Value("${PandaPlate.imgPath}")
    private String baseImgPath;
    @Autowired
    private SetmealDishService setmealDishService;

    @Transactional
    @Override
    public SetmealDto getByIdWithDishes(Long id) {
        Setmeal setmeal = this.getById(id);
        SetmealDto setmealDto = new SetmealDto();
        BeanUtils.copyProperties(setmeal,setmealDto);
        //构造查询
        LambdaQueryWrapper<SetmealDish> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SetmealDish::getSetmealId,id);
        setmealDto.setSetmealDishes(setmealDishService.list(wrapper));
        return setmealDto;
    }

    @Transactional
    @Override
    public void updateWithDishes(SetmealDto setmealDto) {
        //修改setmeal表
        this.updateById(setmealDto);
        //在setmealDish表删除所有带setmealId的记录
        LambdaQueryWrapper<SetmealDish> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SetmealDish::getSetmealId,setmealDto.getId());
        setmealDishService.remove(wrapper);
        //在setmealDish插入新记录
        List<SetmealDish> dishes = setmealDto.getSetmealDishes();
        dishes.forEach(setmealDish -> {
            setmealDish.setSetmealId(setmealDto.getId());
        });
        setmealDishService.saveBatch(dishes);
    }

    @Transactional
    @Override
    public void deleteByIdWithDishes(Long id) {
        Setmeal setmeal= this.getById(id);
        File file = new File(baseImgPath+setmeal.getImage());
        file.delete();
        this.removeById(id);
        LambdaQueryWrapper<SetmealDish> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SetmealDish::getSetmealId,id);
        setmealDishService.remove(wrapper);
    }

    @Override
    @Transactional
    public void saveWithDishes(SetmealDto setmealDto) {
        //保存基础套餐信息至setmeal表
        this.save(setmealDto);

        //保存套餐菜品信息至setmealDish表
        List<SetmealDish> list = setmealDto.getSetmealDishes();
        list.forEach(setmealDish -> {
            setmealDish.setSetmealId(setmealDto.getId());
        });

        setmealDishService.saveBatch(list);
    }
}




