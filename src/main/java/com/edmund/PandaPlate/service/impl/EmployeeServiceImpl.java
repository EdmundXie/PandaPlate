package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.Employee;
import com.edmund.PandaPlate.service.EmployeeService;
import com.edmund.PandaPlate.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
* @author edmundxie
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2023-02-22 22:13:15
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




