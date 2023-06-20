package com.auto.service;

import com.auto.pojo.Picture;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureService {
    PageInfo<Picture> findPage(@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize);

    List<Picture> findAllPicture();
}
