package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.Dish;
import com.edmund.PandaPlate.Pojo.DishFlavor;
import com.edmund.PandaPlate.common.R;
import com.edmund.PandaPlate.dto.DishDto;
import com.edmund.PandaPlate.service.DishFlavorService;
import com.edmund.PandaPlate.service.DishService;
import com.edmund.PandaPlate.mapper.DishMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author edmundxie
* @description 针对表【dish(菜品管理)】的数据库操作Service实现
* @createDate 2023-02-26 23:22:40
*/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{

    @Value("${PandaPlate.imgPath}")
    private String baseImgPath;
    @Autowired
    private DishFlavorService dishFlavorService;

    //根据id查询菜品信息包括口味
    @Override
    public DishDto getByIdWithFlavor(Long id) {
        Dish dish = this.getById(id);
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);
        //构造查询
        LambdaQueryWrapper<DishFlavor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DishFlavor::getDishId,id);
        dishDto.setFlavors(dishFlavorService.list(wrapper));

        return dishDto;
    }

    //更新菜品信息包括口味，需操作两张表
    @Transactional
    @Override

    public void updateWithFlavor(DishDto dishDto) {
        //修改菜品基本信息到菜品表
        this.updateById(dishDto);

        //修改菜品口味信息到口味表，更新dishFlavorService
        //先删除所有口味
        LambdaQueryWrapper<DishFlavor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorService.remove(wrapper);

        //再添加口味
        List<DishFlavor> dishFlavors = dishDto.getFlavors();
        dishFlavors.forEach(dishFlavor -> {
            dishFlavor.setDishId(dishDto.getId());
        });
        dishFlavorService.saveBatch(dishFlavors);
    }

    //删除菜品，需操作两张表
    @Override
    @Transactional
    public void deleteByIdWithFlavor(Long id) {
        Dish dish= this.getById(id);
        File file = new File(baseImgPath+dish.getImage());
        file.delete();
        this.removeById(id);
        LambdaQueryWrapper<DishFlavor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DishFlavor::getDishId,id);
        dishFlavorService.remove(wrapper);
    }

    @Transactional
    @Override
    //新增菜品同时保存对应口味数据
    public void saveWithFlavor(DishDto dishdto) {
        //保存菜品基本信息到菜品表
        this.save(dishdto);

        //保存菜品口味到菜品口味表
        List<DishFlavor> dishFlavors= dishdto.getFlavors();

        //方法1：操作stream流
//        dishFlavors = dishFlavors.stream().map(item->{
//            item.setDishId(dishdto.getId());
//            return item;
//        }).collect(Collectors.toList());

        //方法2：list.forEach方法
        dishFlavors.forEach(dishFlavor -> {
            dishFlavor.setDishId(dishdto.getId());
        });
        dishFlavorService.saveBatch(dishFlavors);

          //方法3：foreach循环
//        for(DishFlavor dishFlavor:dishdto.getFlavors()){
//            dishFlavor.setDishId(dishdto.getId());
//            dishFlavorService.save(dishFlavor);
//        }
    }
}




