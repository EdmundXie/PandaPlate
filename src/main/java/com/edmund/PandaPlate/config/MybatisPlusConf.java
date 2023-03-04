package com.edmund.PandaPlate.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Projectname: PandaPlate
 * @Filename: MybatisPlusConf
 * @Author: EdmundXie
 * @Data:2023/2/25 20:22
 * @Email: 609031809@qq.com
 * @Description:
 */
@Configuration
public class MybatisPlusConf {
    @Bean
    public MybatisPlusInterceptor mpInterceptor(){
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpInterceptor;
    }

}
