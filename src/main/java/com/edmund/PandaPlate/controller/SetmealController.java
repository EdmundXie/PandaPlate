package com.edmund.PandaPlate.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edmund.PandaPlate.Pojo.Category;
import com.edmund.PandaPlate.Pojo.Dish;
import com.edmund.PandaPlate.Pojo.Setmeal;
import com.edmund.PandaPlate.common.R;
import com.edmund.PandaPlate.dto.DishDto;
import com.edmund.PandaPlate.dto.SetmealDto;
import com.edmund.PandaPlate.service.CategoryService;
import com.edmund.PandaPlate.service.SetmealDishService;
import com.edmund.PandaPlate.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Projectname: PandaPlate
 * @Filename: SetmealController
 * @Author: EdmundXie
 * @Data:2023/3/1 19:56
 * @Email: 609031809@qq.com
 * @Description:套餐管理
 */
@RestController
@Slf4j
@RequestMapping("/setmeal")
public class SetmealController {
    //套餐服务类
    @Autowired
    private SetmealService setmealService;

    //套餐菜品服务类
    @Autowired
    private SetmealDishService setmealDishService;

    // 类型类
    @Autowired
    private CategoryService categoryService;


    //新增套餐
    @PostMapping
    public R<String> add(@RequestBody SetmealDto setmealDto){

        setmealService.saveWithDishes(setmealDto);
        return R.success("保存成功");
    }

    //批量删除，需操作两张表
    @DeleteMapping
    public R<String> delete(Long[] ids){
        for(Long id:ids){
            setmealService.deleteByIdWithDishes(id);
        }
        return R.success("删除成功");
    }

    //批量修改status,只需操作一张表
    @PostMapping("/status/{status}")
    public R<String> saleSatus(@PathVariable int status,Long[] ids){
        for(Long id:ids){
            Setmeal setmeal = setmealService.getById(id);
            setmeal.setStatus(status);
            setmealService.updateById(setmeal);
        }
        return R.success("修改菜品状态成功");
    }

    //修改套餐,需操作两张表
    @PutMapping
    public R<String> update(@RequestBody SetmealDto setmealDto){
        setmealService.updateWithDishes(setmealDto);
        return R.success("修改成功");
    }

    //查询单一套餐
    @GetMapping("/{id}")
    public R<SetmealDto> getInfo(@PathVariable Long id){
        SetmealDto setmealDto = setmealService.getByIdWithDishes(id);
        return R.success(setmealDto);
    }

    //分页查询套餐
    @GetMapping("/page")
    public R<Page> getPage(int page, int pageSize,String name){
        Page<Setmeal> pg = new Page<>(page,pageSize);
        Page<SetmealDto> newPage = new Page<>(page,pageSize);

        LambdaQueryWrapper<Setmeal> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(name),Setmeal::getName,name);
        wrapper.orderByDesc(Setmeal::getUpdateTime);
        setmealService.page(pg,wrapper);

        BeanUtils.copyProperties(pg,newPage,"records");
        List<Setmeal> records = pg.getRecords();
        List<SetmealDto> newRecords = records.stream().map(record->{
            SetmealDto setmealDto = new SetmealDto();
            BeanUtils.copyProperties(record,setmealDto);
            Long id = record.getCategoryId();
            Category category = categoryService.getById(id);
            setmealDto.setCategoryName(category.getName());
            return setmealDto;
        }).collect(Collectors.toList());

        newPage.setRecords(newRecords);
        return R.success(newPage);
    }

    //根据id查询套餐list
    //wrapper and 用多个wrapper函数链接
    @GetMapping("/list")
    public R<List<Setmeal>> getList(Long categoryId,Integer status){
        LambdaQueryWrapper<Setmeal> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(categoryId!=null,Setmeal::getCategoryId,categoryId);
        wrapper.eq(status!=null,Setmeal::getStatus,status);
        List<Setmeal> list = setmealService.list(wrapper);
        return R.success(list);
    }
}
