package com.auto.mapper;

import com.auto.pojo.User;
import com.auto.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@ContextConfiguration(locations = "classpath:spring-mvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {
    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(UserMapper.class);
    /**
     * 测试登录
     */
    @Test
    public void selectUser() {
        User user = new User(
                1,
                "lisi",
                "123456"
        );
        User loginUser = userService.getUserByUsernameAndPassword(user);
        logger.debug(loginUser + "");
    }
}