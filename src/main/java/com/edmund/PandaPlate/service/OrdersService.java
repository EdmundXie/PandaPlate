package com.edmund.PandaPlate.service;

import com.edmund.PandaPlate.Pojo.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edmund.PandaPlate.common.R;

/**
* @author edmundxie
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2023-03-03 21:04:38
*/
public interface OrdersService extends IService<Orders> {
    public void submit(Orders orders,Long id);
}
