package com.seed.winter.controller;

import com.seed.utils.isEmptyException;
import com.seed.winter.service.impl.UserServiceImpl;
import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(User user) throws isEmptyException {
        System.out.println(user);
        if ("".equals(user.getName()) || user.getName() == null){
            throw new isEmptyException("用户名不能为空");
        }else if ("".equals(user.getPassWord()) || user.getPassWord() == null){
            throw new isEmptyException("密码不能为空");
        }
        userServiceImpl.registerUser(user);
        return "添加成功";
    }

    @RequestMapping(value = "/selectAll")
    public List<User> selectAll(User user){
        List<User> users = userServiceImpl.selectAll();
        return users;
    }

    @RequestMapping(value = "/updateUserInformation")
    public String UpdateUserInformation(User user){

        userServiceImpl.UpdateUserInformation(user);
        return "修改成功";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public Boolean UserLogin(User user){
        System.out.println(user);
        User isUser = userServiceImpl.UserLogin(user);
        Boolean isExistFlag= !(isUser == null) && !(isUser == null)?true:false;
        System.out.println(isExistFlag);
        return isExistFlag;
    }
}
