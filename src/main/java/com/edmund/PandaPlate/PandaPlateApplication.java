package com.edmund.PandaPlate;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Projectname: PandaPlate
 * @Filename: PandaPlateApplication
 * @Author: EdmundXie
 * @Data:2023/2/22 14:00
 * @Email: 609031809@qq.com
 * @Description:
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.edmund.PandaPlate.mapper")
@EnableTransactionManagement
@ServletComponentScan
public class PandaPlateApplication {
    public static void main(String[] args) {
        SpringApplication.run(PandaPlateApplication.class,args);
        log.info("Start success 启动成功");
    }
}
