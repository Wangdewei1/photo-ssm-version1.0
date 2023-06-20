package com.auto.mapper;

import com.auto.pojo.Picture;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //无意义
public interface PictureMapper {
    List<Picture> findPage(@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize);

    List<Picture> findAllPage();

}
