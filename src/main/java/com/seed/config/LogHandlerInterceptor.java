package com.seed.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Boolean code = (Boolean)request.getSession().getAttribute("code")==null ? false:true;
        System.out.println(code);
        if (code){
            System.out.println("登录成功了");
            return code;
        }
        response.sendRedirect("/index");
        System.out.println("拦截成功了");
        return false;
    }

}
