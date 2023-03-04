package com.edmund.PandaPlate.dto;

import com.edmund.PandaPlate.Pojo.OrderDetail;
import com.edmund.PandaPlate.Pojo.Orders;
import lombok.Data;

import java.util.List;

/**
 * @Projectname: PandaPlate
 * @Filename: OrderDto
 * @Author: EdmundXie
 * @Data:2023/3/4 00:45
 * @Email: 609031809@qq.com
 * @Description:
 */
@Data
public class OrderDto extends Orders {
    //一个订单的所有orderDetails
    private List<OrderDetail> orderDetails;

    //一个orderDetail的dish数量，前端已提供，无需操作
    private int sumNum;

}
