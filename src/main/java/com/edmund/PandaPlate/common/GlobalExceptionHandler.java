package com.edmund.PandaPlate.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @Projectname: PandaPlate
 * @Filename: GlobalExceptionHandler
 * @Author: EdmundXie
 * @Data:2023/2/25 17:06
 * @Email: 609031809@qq.com
 * @Description:全局异常处理工具，开始抛的异常可以写exception，然后根据运行情况再改对应的异常处理操作
 */
@RestControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    //sql相关异常
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        //判断异常信息来选择异常处理操作
        log.error(ex.getMessage());
        String msg = ex.getMessage();
        if(msg.contains("Duplicate entry")){
            String[] split = msg.split(" ");
            return R.error(split[2]+"已存在，请重试");
        }

        return R.error("未知错误");
    }

    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException ex){
        //判断异常信息来选择异常处理操作
        return R.error(ex.getMessage());
    }
}
