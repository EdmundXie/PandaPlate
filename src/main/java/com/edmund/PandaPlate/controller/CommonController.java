package com.edmund.PandaPlate.controller;

import com.edmund.PandaPlate.common.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @Projectname: PandaPlate
 * @Filename: CommonController
 * @Author: EdmundXie
 * @Data:2023/2/28 19:21
 * @Email: 609031809@qq.com
 * @Description:处理文件上传下载
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {


    //将文件通过如输入流上传到服务器并保存到相应位置
    @Value("${PandaPlate.imgPath}")
    private String basePath;
    @PostMapping("/upload")
    public R<String> upload(@RequestPart("file") MultipartFile multipartFile){
        //multipartFile是一个临时文件，需要转存到指定位置，否则本次请求完成后会删除
        //原始文件名
        String originalFilename = multipartFile.getOriginalFilename();

        //取得后缀
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //使用UUID重新生成文件名，防止文件名称重复导致文件覆盖
        String filename = UUID.randomUUID().toString()+postfix;

        //判断basePath是否存在
        File dir = new File(basePath);
        if(!dir.exists()){
            dir.mkdir();
        }
        //保存文件
        try{
            multipartFile.transferTo(new File(basePath+filename));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return R.success(filename);
    }

    //将文件从服务器下载，先通过输入流获取文件位置，再构建输出流
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        //输入流，通过输入流获取文件内容
        //输出流，通过输出流将文件写回服务器

        //response.setContentType(MIME)的作用是使客户端浏览器区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据
        try(FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
            ServletOutputStream servletOutputStream = response.getOutputStream()){
            response.setContentType("image/jpeg");
//            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
//            ServletOutputStream servletOutputStream = response.getOutputStream();

            IOUtils.copy(fileInputStream,servletOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
