package com.auto.service;

import com.auto.pojo.User;

import java.util.List;

/**
 * service 层 User相关操作
 */
public interface UserService {
    User getUserByUsernameAndPassword(User user);

    List<User> findAll();

    User getUserById(Integer id);

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUserById(Integer id);
}
