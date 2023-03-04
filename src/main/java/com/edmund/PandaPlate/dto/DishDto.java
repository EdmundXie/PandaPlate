package com.edmund.PandaPlate.dto;

import com.edmund.PandaPlate.Pojo.Dish;
import com.edmund.PandaPlate.Pojo.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Projectname: PandaPlate
 * @Filename: DishDto
 * @Author: EdmundXie
 * @Data:2023/3/1 12:53
 * @Email: 609031809@qq.com
 * @Description:
 */
@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
