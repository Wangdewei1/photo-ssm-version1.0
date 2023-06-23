package com.auto.controller;

import com.auto.pojo.Picture;
import com.auto.service.PictureService;
import com.auto.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 图片相关操作
 */
@RestController
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    PictureService pictureService;

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("{currentPage}/{pageSize}")
    public ResultVo findUserPageWithCurrentPageAndPageSize(@PathVariable Integer currentPage,
                                                           @PathVariable Integer pageSize){
        //根据当前页，和每页显示数
        PageInfo<Picture> page = pictureService.findPage(currentPage, pageSize);
        if (page == null){
            return new ResultVo(false,"操作失败",null);
        }
        return new ResultVo(
                true,
                "操作成功",
                page
        );

    }

    /**
     * 查询所有图片
     */
    @GetMapping
    public ResultVo findAllPicture(){
        List<Picture> pictureList = pictureService.findAllPicture();
        if (null == pictureList){
            return new ResultVo(
                    false,"没有图片",null
            );
        }
        return new ResultVo(
                true,
                "操作成功",
                pictureList
        );
    }
}
