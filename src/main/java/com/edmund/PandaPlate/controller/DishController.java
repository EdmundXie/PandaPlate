package com.edmund.PandaPlate.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
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

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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

    @Autowired
    private RedisTemplate redisTemplate;

    //新增菜品
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto){
        dishService.saveWithFlavor(dishDto);
        redisTemplate.delete("dish_"+dishDto.getCategoryId()+"_"+dishDto.getStatus());
        return R.success("菜品保存成功");
    }

    //批量删除，需操作两张表
    @DeleteMapping
    public R<String> delete(Long[] ids){
        for(Long id:ids){
            dishService.deleteByIdWithFlavor(id);
        }
        Set keys = redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);
        return R.success("删除成功");
    }

    //批量修改status,只需操作一张表
    @PostMapping("/status/{status}")
    public R<String> saleStatus(@PathVariable int status,Long[] ids){
        for(Long id:ids){
            Dish dish = dishService.getById(id);
            dish.setStatus(status);
            dishService.updateById(dish);
        }
        Set keys = redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);
        return R.success("修改菜品状态成功");
    }


    //修改菜品
    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto){
        dishService.updateWithFlavor(dishDto);
        redisTemplate.delete("dish_"+dishDto.getCategoryId()+"_"+dishDto.getStatus());
        return R.success("修改成功");
    }

    //查询单一菜品
    @GetMapping("/{id}")
    public R<DishDto> getInfo(@PathVariable Long id){
        DishDto dishDto = dishService.getByIdWithFlavor(id);
        return R.success(dishDto);
    }

    //查询一个category下的所有菜品
    //加redis缓存，防止多用户并发访问造成数据库崩溃
    //根据分类查分类下菜品id，查redis
    //
    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish){
        //根据categoryId,查redis，若不为空，直接返回redis中的数据
        List<DishDto> dishDtos = null;
        //动态构造key
        String key = "dish_"+dish.getCategoryId()+"_"+dish.getStatus();
        dishDtos = (List<DishDto>) redisTemplate.opsForValue().get(key);
        if(dishDtos!=null){
            return R.success(dishDtos);
        }
        //若redis为空，查数据库

        LambdaQueryWrapper<Dish> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(dish.getCategoryId()!=null,Dish::getCategoryId,dish.getCategoryId());
        wrapper.eq(Dish::getStatus,1);
        wrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> dishList = dishService.list(wrapper);


        dishDtos = dishList.stream().map(dish1 -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(dish1,dishDto);
            LambdaQueryWrapper<DishFlavor> wp = new LambdaQueryWrapper<>();
            wp.eq(DishFlavor::getDishId,dish1.getId());
            List<DishFlavor> list = dishFlavorService.list(wp);
            dishDto.setFlavors(list);
            return dishDto;
        }).collect(Collectors.toList());

        //查完数据库，需要在redis中插入数据
        redisTemplate.opsForValue().set(key,dishDtos,60, TimeUnit.MINUTES);
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

