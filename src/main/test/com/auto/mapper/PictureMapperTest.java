package com.auto.mapper;

import com.auto.pojo.Picture;
import com.auto.service.PictureService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@ContextConfiguration(locations = "classpath:spring/spring-web.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PictureMapperTest {
    @Autowired
    PictureService pictureService;

    Logger logger = LoggerFactory.getLogger(PictureMapperTest.class);
    /**
     *
     * 根据分页查询
     */
    @Test
    public void findPage() {
        PageInfo<Picture> page = pictureService.findPage(1, 2);
        logger.debug(page + "");
    }
}