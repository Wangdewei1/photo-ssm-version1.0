package com.auto.controller;

import com.auto.pojo.Category;
import com.auto.pojo.Picture;
import com.auto.service.CategoryService;
import com.auto.service.PictureService;
import com.auto.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    PictureService pictureService;
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

    /**
     * 查询 照片根据 cid
     */
    @GetMapping("{cid}")
    public ResultVo getPictureListByCid(@PathVariable Integer cid){

        List<Picture> pictureList = pictureService.getPictureListByCid(cid);

        if (cid == null && cid <= 0){
            return new ResultVo(false,"没有该分类",null);
        }
        return new ResultVo(
                true,
                "操作成功",
                pictureList
        );
    }
}
