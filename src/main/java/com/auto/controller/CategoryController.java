package com.auto.controller;

import com.auto.pojo.Category;
import com.auto.service.CategoryService;
import com.auto.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类模块
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    /**
     * 查询所有分类
     */
    @GetMapping
    public ResultVo findAllCategory(){
        List<Category> categoryList = categoryService.findAllCategory();
        if (categoryList == null){
            return new ResultVo(false,"没有分类",null);
        }
        return new ResultVo(
                true,
                "操作成功",
                categoryList
        );
    }
}
