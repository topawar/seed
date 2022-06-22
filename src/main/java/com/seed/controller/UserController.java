package com.seed.controller;


import com.seed.dao.ArticleDao;
import com.seed.dao.UserDao;
import com.seed.entity.Article;
import com.seed.entity.User;
import com.seed.service.impl.UserServiceImpl;
import com.seed.utils.isEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    ArticleDao articleDao;

    @Autowired
    HttpServletRequest httpServletRequest;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object,Object> UserLogin(User user, HttpServletRequest request) {

        System.out.println(user);
        HashMap<Object,Object> resultMap = new HashMap<Object,Object>();
        User isUser = userServiceImpl.userLogin(user);
        System.out.println(isUser);
        Boolean isExistFlag = isUser != null ? true : false;
        System.out.println(isExistFlag);
        if (isExistFlag){
            request.getSession().setAttribute("user",isUser);
            request.getSession().setAttribute("code",true);
            resultMap.put("code","200");
        }else {
            resultMap.put("code","500");
            resultMap.put("msg","用户名或密码错误");
        }
        return resultMap;
    }

    @RequestMapping(value = {"/index", "", "/"})
    public String test() {

        return "index";
    }

    @RequestMapping(value = {"/index_forward"})
    public String register() {

        return "register";
    }

    @RequestMapping(value = {"/bk_index"})
    public ModelAndView test2() {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");
        modelAndView.setViewName("bk_index");
        System.out.println(user);
        modelAndView.addObject("articles",articleDao.getArticleList());
        modelAndView.addObject("kinds",articleDao.getAllArticleKind());
        modelAndView.addObject("user", userServiceImpl.userGetById(user.getUid()));
        return modelAndView;
    }
}