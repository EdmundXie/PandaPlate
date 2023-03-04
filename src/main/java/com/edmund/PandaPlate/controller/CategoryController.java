package com.edmund.PandaPlate.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edmund.PandaPlate.Pojo.Category;
import com.edmund.PandaPlate.common.R;
import com.edmund.PandaPlate.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Projectname: PandaPlate
 * @Filename: CategoryController
 * @Author: EdmundXie
 * @Data:2023/2/26 12:14
 * @Email: 609031809@qq.com
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //新增菜品/套餐分类
    @PostMapping
    public R<String> addCategory(@RequestBody Category category){
        log.info("新增分类{}",category);
        categoryService.save(category);
        return R.success("添加成功");
    }

    //分类分页
    @GetMapping("/page")
    public R<Page> categoryPage(int page,int pageSize){
        Page<Category> pg = new Page<>(page,pageSize);
        LambdaQueryWrapper<Category> wrapper= new LambdaQueryWrapper<>();
        //根据sort升序排序
        wrapper.orderByAsc(Category::getSort);
        categoryService.page(pg,wrapper);
        return R.success(pg);
    }

    //删除分类
    @DeleteMapping
    public R<String> deleteCategory(Long ids){
        categoryService.remove(ids);
        return R.success("分类信息删除成功");
    }

    //修改分类
    @PutMapping
    public R<String> updateCategory(@RequestBody Category category){
        categoryService.updateById(category);
        return R.success("修改成功");
    }

    //根据条件查询，返回列表
    @GetMapping("/list")
    public R<List<Category>> getList(Category category){
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(category.getType()!=null,Category::getType,category.getType());
        wrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> categoryList = categoryService.list(wrapper);

        if(categoryList.size()==0){
            return R.error("请先添加菜品分类");
        }
        //判断
        return R.success(categoryList);
    }

}
