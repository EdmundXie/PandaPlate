package com.edmund.PandaPlate.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.edmund.PandaPlate.Pojo.User;
import com.edmund.PandaPlate.common.R;
import com.edmund.PandaPlate.service.UserService;
import com.edmund.PandaPlate.utils.SMSUtils;
import com.edmund.PandaPlate.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Projectname: PandaPlate
 * @Filename: UserController
 * @Author: EdmundXie
 * @Data:2023/3/2 02:14
 * @Email: 609031809@qq.com
 * @Description:
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    //发送手机验证码
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        //获取手机号
        String phone = user.getPhone();
        if(!StringUtils.isEmpty(phone)){

            //生成随机四位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();

            //调用阿里云短信服务API发送短信
//            SMSUtils.sendMessage("验证码短信",key,phone,code);
            log.info("code = {}",code);

            //需要将生成的验证码保存起在session中校验
//            session.setAttribute(phone,code);

            //将生成的验证码缓存到redis中，并设置时间限制
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);

            return R.success("短信发送成功,code="+code+"");
        }
        return R.error("短信发送失败");
    }

    //用户登录
    @PostMapping("/login")
    public R<User> login(@RequestBody Map userMap, HttpSession session){

        String phone = userMap.get("phone").toString();
        String code = userMap.get("code").toString();

        //如果手机验证码与之前session存的一致且不为空
        String inputCode = (String) redisTemplate.opsForValue().get(phone);
        if(code!=null&&inputCode.equals(code)){
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getPhone,phone);
            User user = userService.getOne(wrapper);

            //若为新用户（数据库中没该用户）
            if(user==null){
                //创建新用户
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            //保存登录信息
            session.setAttribute("user",user.getId());

            //如果登录成功，删除redis中缓存的code
            redisTemplate.delete(phone);

            return R.success(user);
        }
        return R.error("验证码错误");
    }

    @PostMapping("/loginout")
    public R<String> logout(HttpSession session){
        session.removeAttribute("user");
        return R.success("退出成功");
    }
}
