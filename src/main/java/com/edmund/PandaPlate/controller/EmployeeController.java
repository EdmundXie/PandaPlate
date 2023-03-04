package com.edmund.PandaPlate.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edmund.PandaPlate.Pojo.Employee;
import com.edmund.PandaPlate.common.R;
import com.edmund.PandaPlate.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Projectname: PandaPlate
 * @Filename: EmployeeController
 * @Author: EdmundXie
 * @Data:2023/2/22 22:33
 * @Email: 609031809@qq.com
 * @Description:R<T>为返回的response，为json格式
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //登录方法，request用于设置session保存登录的员工id，RequestBody用于接受输入的员工信息
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        //1、将页面提交的密码进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //2、根据页面提交的用户名来查数据库
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();//Lambda查询条件构造器
        wrapper.eq(Employee::getUsername,employee.getUsername());//查询操作，判断两个username是否相等
        Employee emp = employeeService.getOne(wrapper);//返回查询的员工对象
        //3、如果没有查询到则返回失败结果
        if(emp==null){
            return R.error("登录失败");
        }

        //4、比对密码，如果不一致则返回失败结果
        if(!emp.getPassword().equals(password)){
            return R.error("密码错误");
        }

        //5、查看员工状态，如果已禁用状态，则返回员工已禁用结果
        if(emp.getStatus()==0){
            return R.error("员工已被封号，请联系管理员");
        }
        //6、登录成功，将用户id存入Session并返回成功结果

        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

    //登出账户
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        //清理Session中保存的当前员工登录的id
        request.getSession().removeAttribute("employee");
        return R.success("注销成功");
    }

    //新增员工
    @PostMapping
    public R<String> addEmployee(HttpServletRequest request,@RequestBody Employee employee){
        /**
         * 不建议在增加之前查询，会增加数据库的压力，因此直接添加，并需要我们的程序进行异常捕获，通常有两种处理方式:
         * 1、在Controller方法中加入try.catch进行异常捕获
         * 2、使用异常处理器进行全局异常捕获
         * 这里选择第二种，因为有很多地方需要捕获这种异常
         * */
//        //查询employee是否已经添加过
//        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Employee::getUsername,employee.getUsername());
//        Employee emp = employeeService.getOne(wrapper);
//        if(emp!=null){
//            return R.error("用户名已存在");
//        }

        //初始化未填信息
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        //填充公共字段，用mybatisplus的功能实现
//        employee.setCreateTime(LocalDateTime.now());
//        employee.setUpdateTime(LocalDateTime.now());
//
//        Long curId = (Long) request.getSession().getAttribute("employee");
//        employee.setCreateUser(curId);
//        employee.setUpdateUser(curId);

        employeeService.save(employee);
        return R.success("添加成功");
    }

    //分页查询
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        //创建分页构造器
        Page pageInfo = new Page(page,pageSize);

        //创建条件构造器
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(name),Employee::getName,name);
        wrapper.orderByDesc(Employee::getUpdateTime);

        //执行查询
        employeeService.page(pageInfo,wrapper);
        return R.success(pageInfo);
    }

    //由于启用禁用员工在sql层与编辑员工类似，即update方法，因此只写update提高代码复用性
    //根据id修改改员工信息


    //分页查询时服务端响应给页面的数据中id的值为19位数字，类型为long
    //页面中js处理long型数字只能精确到前16位，所以最终通过ajax请求提交给服务端的时候id就改变了
    //前面我们已经发现了问题的原因，即js对long型数据进行处理时丢失精度，导致提交的id和数据库中的id不一致。
    //
    //如何解决这个问题?
    //我们可以在服务端给页面响应json数据时进行处理，将long型数据统一转为String字符串。
    @PutMapping
    public R<String> update(@RequestBody Employee employee){

//        Long curId = (Long) request.getSession().getAttribute("employee");
//        employee.setUpdateTime(LocalDateTime.now());
//        employee.setUpdateUser(curId);
        employeeService.updateById(employee);
        return R.success("员工信息修改成功");
    }

    //编辑员工信息页面回显示
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id){
        Employee emp = employeeService.getById(id);
        if(emp!=null){
            return R.success(emp);
        }
        return R.error("未查询到相关员工信息");
    }
}
