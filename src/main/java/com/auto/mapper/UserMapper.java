package com.auto.mapper;

import com.auto.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUser(@Param("username") String username, @Param("pwd") String pwd);
}
