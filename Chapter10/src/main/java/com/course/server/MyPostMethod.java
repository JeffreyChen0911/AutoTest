package com.course.server;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是我全部的post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    // 这个变量是我们用来装我们cookies信息的
    private static Cookie cookie;

    //用户登录登录成功获取到cookies，然后再访问其他接口获取到列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password){
        if(userName.equals("zhangsan") && password.equals("123456")){
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功了！";
        }
        return "用户名或者是密码错误！";
    }

}
