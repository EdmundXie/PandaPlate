package com.edmund.PandaPlate.service;

import com.edmund.PandaPlate.Pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author edmundxie
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2023-02-26 12:08:21
*/
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
