package com.seed.controller;


import com.seed.entity.User;
import com.seed.service.impl.UserServiceImpl;
import com.seed.utils.isEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @ResponseBody
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

    @ResponseBody
    @RequestMapping(value = "/selectAll")
    public List<User> selectAll(User user){
        List<User> users = userServiceImpl.selectAll();
        return users;
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserInformation")
    public String UpdateUserInformation(User user){

        userServiceImpl.UpdateUserInformation(user);
        return "修改成功";
    }

    @ResponseBody
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public Boolean UserLogin(User user,HttpServletRequest request){
        System.out.println(user);
        User isUser = userServiceImpl.UserLogin(user);
        Boolean isExistFlag= !(isUser == null) && !(isUser == null)?true:false;
        System.out.println(isExistFlag);
        return isExistFlag;
    }

    @RequestMapping(value = {"/index","","/"})
    public String  test(){

        return "index";
    }
}