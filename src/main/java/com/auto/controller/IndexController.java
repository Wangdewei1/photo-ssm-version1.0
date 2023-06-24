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

    /**
     * 登录后台管理页
     */
    @RequestMapping("/admin/index.html")
    public String toAdminIndex(){
        return "admin/index";
    }

    /**
     * 后台管理 添加页面
     */
    @RequestMapping("/admin/add.html")
    public String toAdminAddPage(){
        return "admin/add";
    }

    /**
     * 后台管理 编辑页面
     */
    @RequestMapping("/admin/edit.html")
    public String toAdminEditPage(){
        return "admin/edit";
    }
}
