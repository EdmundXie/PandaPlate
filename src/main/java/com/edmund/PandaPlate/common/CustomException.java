package com.edmund.PandaPlate.common;

/**
 * @Projectname: PandaPlate
 * @Filename: CustomException
 * @Author: EdmundXie
 * @Data:2023/2/26 23:46
 * @Email: 609031809@qq.com
 * @Description:
 */
public class CustomException extends RuntimeException{
    public CustomException(String msg){
        super(msg);
    }
}
