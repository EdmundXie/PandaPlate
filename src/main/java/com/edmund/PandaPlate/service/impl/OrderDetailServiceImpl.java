package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.OrderDetail;
import com.edmund.PandaPlate.service.OrderDetailService;
import com.edmund.PandaPlate.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author edmundxie
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2023-03-03 21:04:38
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




