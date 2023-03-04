package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.ShoppingCart;
import com.edmund.PandaPlate.service.ShoppingCartService;
import com.edmund.PandaPlate.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author edmundxie
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2023-03-03 15:06:46
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

}




