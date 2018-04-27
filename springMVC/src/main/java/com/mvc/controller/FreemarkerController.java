package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jiangkai on 2018/4/25.
 */

@Controller
@RequestMapping(value = "/")
public class FreemarkerController {

    @RequestMapping("/hi")
    public String hi(ModelMap map){
        System.out.println("say hi ……");

        map.put("name", "kimi");

        return "hi";
    }
}
