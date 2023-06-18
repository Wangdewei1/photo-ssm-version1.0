package com.auto.controller;

import com.auto.pojo.User;
import com.auto.service.UserService;
import com.auto.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")

    public ResultVo<User> login(@PathVariable @RequestBody User user, Model model){
        logger.debug(user + "");

        //登录
        User loginUser = userService.getUserByUsernameAndPassword(user);


        if (null == loginUser){
            model.addAttribute("errorMsg", "登录失败，用户名或密码错误");
            return new ResultVo<User>(
                    false,
                    "登陆失败,账户或密码不正确",
                    null
            );
        }


        return new ResultVo(
                true,
                "登陆成功",
                user
        );
    }
}
