package com.edmund.PandaPlate.common;

/**
 * @Projectname: PandaPlate
 * @Filename: BaseContext
 * @Author: EdmundXie
 * @Data:2023/2/26 11:37
 * @Email: 609031809@qq.com
 * @Description:
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户的id
 * 以代理模式补充和加强ThreadLocal类
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
