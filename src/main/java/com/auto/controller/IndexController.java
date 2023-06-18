package com.auto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index.html")
    public String toIndexPage(){
        return "index";
    }
    @RequestMapping("/login.html")
    public String toLoginPage(){
        return "login";
    }

    @RequestMapping("/picture.html")
    public String toPicturePage(){
        return "picture";
    }
}
