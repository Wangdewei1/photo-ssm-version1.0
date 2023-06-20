package com.auto.service.impl;

import com.auto.mapper.PictureMapper;
import com.auto.pojo.Picture;
import com.auto.service.PictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureMapper pictureMapper;
    /**
     * 分页查询图片
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageInfo<Picture> findPage(Integer currentPage, Integer pageSize) {
        //开启分页
        PageHelper.startPage(currentPage,pageSize);

        List<Picture> pictureList = pictureMapper.findAllPage();
        //navigatePages 最多在这个页面，显示的页码数量
        return new PageInfo<Picture>(pictureList,8);
    }

    /**
     * 查所有图片
     * @return
     */
    public List<Picture> findAllPicture() {
        return pictureMapper.findAllPage();
    }
}
