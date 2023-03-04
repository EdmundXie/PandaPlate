package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.DishFlavor;
import com.edmund.PandaPlate.service.DishFlavorService;
import com.edmund.PandaPlate.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author edmundxie
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2023-03-01 00:28:44
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
    implements DishFlavorService{

}




