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

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration(locations = "classpath:spring/spring-web.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
    /**
     * 测试登录
     */
    @Test
    public void selectUser() {
        User user = new User(
                1,
                "zhangsan",
                "123456"
        );
        User loginUser = userService.getUserByUsernameAndPassword(user);
        logger.debug(loginUser + "");
    }

    /**
     * 查询所有user
     */
    @Test
    public void findAll(){
        List<User> userList = userMapper.findAll();
        logger.debug(userList + "");
    }

    /**
     * 根据id查询User
     */
    @Test
    public void getUserById(){
        User user = userMapper.getUserById(1);
        logger.debug(user + "");
    }

    /**
     * 根据id删除User
     */
    @Test
    public void deleteUserById() {
        Integer rows = userMapper.deleteUserById(2);
        logger.debug(rows + "");
    }

    /**
     * 新增User
     */
    @Test
    public void insertUser() {
        Integer rows = userMapper.insertUser("赵八","123123");
        logger.debug(rows + "行执行了");
    }

    /**
     * 更新User
     */
    @Test
    public void updateUser() {
        Integer rows = userMapper.updateUser(new User(2,"wangwu","123456"));
        logger.debug(rows + "");
    }
}