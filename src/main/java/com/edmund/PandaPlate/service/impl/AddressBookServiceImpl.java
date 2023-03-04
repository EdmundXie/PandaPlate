package com.edmund.PandaPlate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edmund.PandaPlate.Pojo.AddressBook;
import com.edmund.PandaPlate.service.AddressBookService;
import com.edmund.PandaPlate.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author edmundxie
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2023-03-03 00:15:20
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




