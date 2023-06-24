package com.auto.service;

import com.auto.exception.UserStatusException;
import com.auto.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * service 层 User相关操作
 */
public interface UserService {
    User getUserByUsernameAndPassword(User user) throws UserStatusException;

    List<User> findAll();

    User getUserById(Integer id);

    Integer insertUser(User user);

    Integer updateUser(Integer id,String username,String pwd);

    Integer deleteUserById(Integer id);
}
