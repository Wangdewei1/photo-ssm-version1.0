package com.auto.mapper;

import com.auto.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层 关于用户操作的接口
 */

@Repository //此注解在此项目没有意义 ，为了让解决idea注入报错
public interface UserMapper {
    User selectUser(@Param("username") String username, @Param("pwd") String pwd);

    List<User> findAll();

    User getUserById(Integer id);

    Integer deleteUserById(Integer id);

    Integer insertUser(@Param("username") String username,@Param("pwd") String pwd);

    Integer updateUser(User user);
}
