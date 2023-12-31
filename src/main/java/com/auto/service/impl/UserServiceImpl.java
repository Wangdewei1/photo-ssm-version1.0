package com.auto.service.impl;

import com.auto.aspect.EveryServiceMethodTimeTotalAspect;
import com.auto.exception.UserStatusException;
import com.auto.mapper.LogMapper;
import com.auto.mapper.UserMapper;
import com.auto.pojo.User;
import com.auto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    LogMapper logMapper;

    /**
     * 登录操作
     * @param
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true) //如果当前存在事务，就加入该事务；如果当前不存在事务，就以非事务执行
    public User getUserByUsernameAndPassword(User user) throws UserStatusException {

        if (user.getUsername() == null || user.getPwd() == null){
            throw new UserStatusException(401,"登陆失败,账户或密码不可以为空");
        }

        if (user.getUsername() != null && user.getPwd() != null){
            //添加日志
            logMapper.insertLogInfo(EveryServiceMethodTimeTotalAspect.getLogInfo());
            return userMapper.selectUser(user);
        }
        return null;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findAll() {
        //添加日志
        logMapper.insertLogInfo(EveryServiceMethodTimeTotalAspect.getLogInfo());
        return userMapper.findAll();
    }

    /**
     * 根据用户id查询User
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User getUserById(Integer id) {
        if (id == null){
            return null;
        }
        //添加日志
        logMapper.insertLogInfo(EveryServiceMethodTimeTotalAspect.getLogInfo());
        return userMapper.getUserById(id);
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Integer insertUser(User user) {
        if (user == null){
            return null;
        }
        //添加日志
        logMapper.insertLogInfo(EveryServiceMethodTimeTotalAspect.getLogInfo());
        return userMapper.insertUser(user.getUsername(),user.getPwd());
    }

    /**
     * 更新用户信息
     * @param
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Integer updateUser(Integer id,String username,String pwd) {
        //添加日志
        logMapper.insertLogInfo(EveryServiceMethodTimeTotalAspect.getLogInfo());
        return userMapper.updateUser(id,username,pwd);
    }

    /**
     * 根据用户id删除User
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Integer deleteUserById(Integer id) {
        //添加日志
        logMapper.insertLogInfo(EveryServiceMethodTimeTotalAspect.getLogInfo());
        return userMapper.deleteUserById(id);
    }
}
