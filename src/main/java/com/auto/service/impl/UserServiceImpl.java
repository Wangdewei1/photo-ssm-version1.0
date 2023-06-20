package com.auto.service.impl;

import com.auto.mapper.UserMapper;
import com.auto.pojo.User;
import com.auto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 登录操作
     * @param user
     * @return
     */
    public User getUserByUsernameAndPassword(User user) {
        if (user != null){
            return userMapper.selectUser(user.getUsername(),user.getPwd());
        }
        return null;
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 根据用户id查询User
     * @param id
     * @return
     */
    public User getUserById(Integer id) {
        if (id == null){
            return null;
        }
        return userMapper.getUserById(id);
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    public Integer insertUser(User user) {
        if (user == null){
            return null;
        }
        return userMapper.insertUser(user.getUsername(),user.getPwd());
    }

    /**
     * 更新用户信息
     * @param
     * @return
     */
    public Integer updateUser(User user) {
        return userMapper.updateUser(new User(user.getId(),user.getUsername(),user.getPwd()));
    }

    /**
     * 根据用户id删除User
     * @param id
     * @return
     */
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }
}
