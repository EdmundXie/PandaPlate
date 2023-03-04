package com.edmund.PandaPlate.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edmund.PandaPlate.Pojo.Category;
import com.edmund.PandaPlate.Pojo.Dish;
import com.edmund.PandaPlate.Pojo.DishFlavor;
import com.edmund.PandaPlate.dto.DishDto;
import com.edmund.PandaPlate.common.R;
import com.edmund.PandaPlate.service.CategoryService;
import com.edmund.PandaPlate.service.DishFlavorService;
import com.edmund.PandaPlate.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Projectname: PandaPlate
 * @Filename: DishController
 * @Author: EdmundXie
 * @Data:2023/3/1 00:29
 * @Email: 609031809@qq.com
 * @Description:
 *
 * 菜品管理
 */
@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private DishFlavorService dishFlavorService;

    @Autowired
    private CategoryService categoryService;

    //新增菜品
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto){
        dishService.saveWithFlavor(dishDto);
        return R.success("菜品保存成功");
    }

    //批量删除，需操作两张表
    @DeleteMapping
    public R<String> delete(Long[] ids){
        for(Long id:ids){
            dishService.deleteByIdWithFlavor(id);
        }
        return R.success("删除成功");
    }

    //批量修改status,只需操作一张表
    @PostMapping("/status/{status}")
    public R<String> saleSatus(@PathVariable int status,Long[] ids){
        for(Long id:ids){
            Dish dish = dishService.getById(id);
            dish.setStatus(status);
            dishService.updateById(dish);
        }
        return R.success("修改菜品状态成功");
    }


    //修改菜品
    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto){
        dishService.updateWithFlavor(dishDto);
        return R.success("修改成功");
    }

    //查询单一菜品
    @GetMapping("/{id}")
    public R<DishDto> getInfo(@PathVariable Long id){
        DishDto dishDto = dishService.getByIdWithFlavor(id);
        return R.success(dishDto);
    }

    //查询一个category下的所有菜品
    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish){
        LambdaQueryWrapper<Dish> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dish::getCategoryId,dish.getCategoryId());
        List<Dish> dishList = dishService.list(wrapper);

        List<DishDto> dishDtos = new ArrayList<>();
        dishList.forEach(dish1 -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(dish1,dishDto);
            LambdaQueryWrapper<DishFlavor> wp = new LambdaQueryWrapper<>();
            wp.eq(DishFlavor::getDishId,dish1.getId());
            List<DishFlavor> list = dishFlavorService.list(wp);
            dishDto.setFlavors(list);
            dishDtos.add(dishDto);
        });

        return R.success(dishDtos);
    }


    //分页查询菜品
    //需要展现图片与菜品分类
    @GetMapping("/page")
    public R<Page> dishPage(int page, int pageSize, String name){
        //创建页
        Page<Dish> pg = new Page<>(page,pageSize);
        Page<DishDto> dtoPage = new Page<>();


        //构造查询器
        LambdaQueryWrapper<Dish> wrapper = new LambdaQueryWrapper<>();

        //需要联合两张表
        wrapper.like(!StringUtils.isEmpty(name),Dish::getName,name);
        wrapper.orderByDesc(Dish::getUpdateTime);

        //返回查询结果
        dishService.page(pg,wrapper);

        //对象拷贝
        BeanUtils.copyProperties(pg,dtoPage,"records");
        List<Dish> records = pg.getRecords();
        List<DishDto> newRecords = records.stream().map(record->{
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(record,dishDto);
            Long id = dishDto.getCategoryId();
            //根据id查category对象
            Category category = categoryService.getById(id);
            if(category!=null){
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            return dishDto;
        }).collect(Collectors.toList());
        dtoPage.setRecords(newRecords);
        return R.success(dtoPage);
    }
}

