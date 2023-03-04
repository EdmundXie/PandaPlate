package com.edmund.PandaPlate.controller;

import com.edmund.PandaPlate.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Projectname: PandaPlate
 * @Filename: OrderDetailController
 * @Author: EdmundXie
 * @Data:2023/3/3 21:09
 * @Email: 609031809@qq.com
 * @Description:
 */
@RestController
@RequestMapping("/orderDetail")
@Slf4j
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

}
