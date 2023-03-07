package com.edmund.PandaPlate.filter;

import com.alibaba.fastjson.JSON;
import com.edmund.PandaPlate.common.BaseContext;
import com.edmund.PandaPlate.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Projectname: PandaPlate
 * @Filename: LoginCheckFilter
 * @Author: EdmundXie
 * @Data:2023/2/25 13:06
 * @Email: 609031809@qq.com
 * @Description:检查用户是否完成登录
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
public static final AntPathMatcher PATH_MATCHER=new AntPathMatcher();

//可以改进的需求
//写一个过滤器，检查用户是否登录
    //user登录后只能访问前台页面
    //employee登录后只能访问后台页面
    //user和employee都可以访问公共页面
    //如果未登录，返回登录结果
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();

        //定义不需要登录处理的路径
        String[] publicUriList = {"/employee/login","/employee/logout", "/backend/**", "/front/**","/common/**","/user/sendMsg","/user/login"};

        if(check(publicUriList,uri)){
            //如不需要处理，放行
            filterChain.doFilter(req,res);
            return;
        }
        if(req.getSession().getAttribute("employee")!=null){
            //判断登录状态
            Long curId = (Long) req.getSession().getAttribute("employee");
            BaseContext.setCurrentId(curId);
            filterChain.doFilter(req,res);//请求放行
            return;
        }
        if(req.getSession().getAttribute("user")!=null){
            Long userId = (Long) req.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(req,res);
            return;
        }
        res.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));//如果未登录，返回登录结果
    }
    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match==true){
                return true;
            }
        }
        return  false;
    }
}
