package com.auto.service;

import com.auto.pojo.User;

public interface UserService {
    User getUserByUsernameAndPassword(User user);
}
