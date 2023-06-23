package com.auto.mapper;

import com.auto.pojo.Log;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * 日志测试
 */
@ContextConfiguration(locations = "classpath:spring/spring-web.xml")
public class LogMapperTest {
    @Autowired
    LogMapper logMapper;

    Logger logger = LoggerFactory.getLogger(LogMapperTest.class);

    /**
     * 插入日志信息
     */
    @Test
    public void insertLogInfo() {

        Integer rows = logMapper.insertLogInfo(new Log(null,"insert",new Date().toString()));

        logger.debug(rows + "");
    }
}