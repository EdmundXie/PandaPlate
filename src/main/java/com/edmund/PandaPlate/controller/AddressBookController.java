package com.edmund.PandaPlate.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.edmund.PandaPlate.Pojo.AddressBook;
import com.edmund.PandaPlate.common.R;
import com.edmund.PandaPlate.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Projectname: PandaPlate
 * @Filename: AddressBookController
 * @Author: EdmundXie
 * @Data:2023/3/3 00:19
 * @Email: 609031809@qq.com
 * @Description:
 */
@RestController
@RequestMapping("/addressBook")
@Slf4j
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    //新增地址
    @PostMapping
    public R<String> saveAddress(@RequestBody AddressBook addressBook,HttpSession session){
        addressBook.setUserId((Long) session.getAttribute("user"));
        addressBookService.save(addressBook);
        return R.success("添加地址成功");
    }

    //更新地址
    @PutMapping
    public R<String> updateAddress(@RequestBody AddressBook addressBook){
        if(addressBook.getId()==null){
            return R.error("修改失败找不到该地址");
        }
        addressBookService.updateById(addressBook);
        return R.success("修改成功");
    }


    //设置默认地址
    @Transactional
    @PutMapping("/default")
    public R<AddressBook> setDefault(@RequestBody AddressBook addressBook,HttpSession session){
        //根据员工id，查该员工的所有地址
        LambdaUpdateWrapper<AddressBook> wrapper = new LambdaUpdateWrapper<>();
        Long curId = (Long) session.getAttribute("user");
        wrapper.eq(curId!=null,AddressBook::getUserId,curId);

        //将其他地址设置isdefault=0
        wrapper.set(AddressBook::getIsDefault,0);
        addressBookService.update(wrapper);

        //设置该地址isdefault=1
        addressBook.setIsDefault(1);
        addressBookService.updateById(addressBook);//动态更新
        return R.success(addressBook);
    }

    //获取默认地址
    @GetMapping("/default")
    public R<AddressBook> getDefault(HttpSession session){
        LambdaQueryWrapper<AddressBook> wrapper = new LambdaQueryWrapper<>();
        Long curId = (Long) session.getAttribute("user");
        wrapper.eq(curId!=null,AddressBook::getUserId,curId);
        wrapper.eq(AddressBook::getIsDefault,1);

        AddressBook addressBook = addressBookService.getOne(wrapper);
        if(addressBook==null){
            return R.error("该用户没有默认地址");
        }
        return R.success(addressBook);
    }



    //根据addressBook_id查询AddressBook进行回显示
    @GetMapping("/{id}")
    public R<AddressBook> getAddress(@PathVariable Long id){
        AddressBook addressBook = addressBookService.getById(id);
        if(addressBook==null){
            return R.error("未找到该地址");
        }
        return R.success(addressBook);
    }

    //查询所有地址
    @GetMapping("/list")
    public R<List<AddressBook>> getList(HttpSession session){
        Long curId = (Long) session.getAttribute("user");


        LambdaQueryWrapper<AddressBook> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(curId!=null,AddressBook::getUserId,curId);
        List<AddressBook> list = addressBookService.list(wrapper);

        return R.success(list);

    }
}
