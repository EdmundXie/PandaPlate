package com.edmund.PandaPlate.dto;

import com.edmund.PandaPlate.Pojo.Setmeal;
import com.edmund.PandaPlate.Pojo.SetmealDish;
import lombok.Data;

import java.util.List;

/**
 * @Projectname: PandaPlate
 * @Filename: SetmealDto
 * @Author: EdmundXie
 * @Data:2023/3/1 19:54
 * @Email: 609031809@qq.com
 * @Description:
 */
@Data
public class SetmealDto extends Setmeal {
    private List<SetmealDish> setmealDishes;
    private String categoryName;
}
