package com.auto.service.impl;

import com.auto.aspect.EveryServiceMethodTimeTotalAspect;
import com.auto.mapper.LogMapper;
import com.auto.mapper.PictureMapper;
import com.auto.pojo.Picture;
import com.auto.service.PictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureMapper pictureMapper;
    @Autowired
    LogMapper logMapper;
    /**
     * 分页查询图片
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageInfo<Picture> findPage(Integer currentPage, Integer pageSize) {
        //添加日志
        logMapper.insertLogInfo(EveryServiceMethodTimeTotalAspect.getLogInfo());
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
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Picture> findAllPicture() {
        //查看所有照片不添加日志了，耗内存，占资源访问时间
//        logMapper.insertLogInfo(EveryServiceMethodTimeTotalAspect.getLogInfo());
        return pictureMapper.findAllPage();
    }

    /**
     * 根据cid查找所有图片
     * @param cid
     * @return
     */
    public List<Picture> getPictureListByCid(Integer cid) {
        logMapper.insertLogInfo(EveryServiceMethodTimeTotalAspect.getLogInfo());
        return pictureMapper.getPictureListByCid(cid);
    }
}
