package com.auto.service.impl;

import com.auto.mapper.UserMapper;
import com.auto.pojo.User;
import com.auto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User getUserByUsernameAndPassword(User user) {
        if (user != null){
            return userMapper.selectUser(user.getUsername(),user.getPwd());
        }
        return null;
    }
}
