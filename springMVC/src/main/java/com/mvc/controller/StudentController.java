package com.mvc.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jiangkai on 2018/4/25.
 */
/*
默认为singleton单例模式，对应配置中的<bean scope="prototype"/>
 */
@Scope(value = "prototype")
/*
请求映射，链接地址第一层满足指定的value则进入这个控制类中的方法
 */
@RequestMapping(value = "springMVC/")
/*
指定当前类为控制类，value可以重命名（无法自动装配）
不使用注解时，需实现org.springframework.web.servlet.mvc.Controller接口
 */
@Controller
public class StudentController {
    @RequestMapping(
            value = "add.html",
            method = RequestMethod.GET
    )
    public String addStu(){
        System.out.println("add.html");
        return "index";
    }
}
