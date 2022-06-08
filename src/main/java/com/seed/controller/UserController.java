package com.seed.controller;


import com.seed.entity.User;
import com.seed.service.impl.UserServiceImpl;
import com.seed.utils.isEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user) throws isEmptyException {
        System.out.println(user);
        if ("".equals(user.getName()) || user.getName() == null) {
            throw new isEmptyException("用户名不能为空");
        } else if ("".equals(user.getPassWord()) || user.getPassWord() == null) {
            throw new isEmptyException("密码不能为空");
        }
        Integer code = userServiceImpl.registerUser(user);
        if (code==1){
            return "添加成功";
        }
        return "用户名已存在";
    }

    @ResponseBody
    @RequestMapping(value = "/selectAll")
    public List<User> selectAll(User user) {
        List<User> users = userServiceImpl.selectAll();
        return users;
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserInformation")
    public String UpdateUserInformation(User user) {

        userServiceImpl.updateUserInformation(user);
        return "修改成功";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Boolean UserLogin(User user, HttpServletRequest request) {

        System.out.println(user);
        User isUser = userServiceImpl.userLogin(user);
        System.out.println(isUser);
        Boolean isExistFlag = !(isUser == null) && !(isUser == null) ? true : false;
        System.out.println(isExistFlag);
        request.getSession().setAttribute("code", isExistFlag);
        request.getSession().setAttribute("user",user);
        return isExistFlag;
    }

    @RequestMapping(value = {"/index", "", "/"})
    public String test() {

        return "index";
    }

    @RequestMapping(value = {"/index_forward"})
    public String register() {

        return "register";
    }

    @RequestMapping(value = {"/test"})
    public String test2() {

        System.out.println("进入test方法");
        return "/test";
    }
}