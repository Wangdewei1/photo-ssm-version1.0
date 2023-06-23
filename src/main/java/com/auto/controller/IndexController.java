package com.auto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面
 */
@Controller
public class IndexController {
    /**
     * 主页
     * @return
     */
    @RequestMapping("/index.html")
    public String toIndexPage(){
        return "index";
    }

    /**
     * 登陆页面
     * @return
     */
    @RequestMapping("/login.html")
    public String toLoginPage(){
        return "login";
    }

    /**
     * 个人相册页面
     * @return
     */
    @RequestMapping("/picture.html")
    public String toPicturePage(){
        return "picture";
    }

    /**
     * 照片分类页面
     * @return
     */
    @RequestMapping("/category.html")
    public String toCategoryPage(){
        return "category";
    }
}
