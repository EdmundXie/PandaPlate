package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.User;
import com.edmund.PandaPlate.service.UserService;
import com.edmund.PandaPlate.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author edmundxie
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2023-03-02 02:13:42
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




