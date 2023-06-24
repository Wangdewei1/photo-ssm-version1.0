package com.auto.controller;

import com.auto.pojo.User;
import com.auto.service.UserService;
import com.auto.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login/{username}/{pwd}")
    public ResultVo login(@PathVariable @RequestBody String username, @PathVariable @RequestBody String pwd){
        //登录
        User user = userService.getUserByUsernameAndPassword(username,pwd);
        logger.debug(user + "");
        if (null == user){
            return new ResultVo(
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

    /**
     * 查询所有用户
     */
    @GetMapping("/findAll")
    public ResultVo findAll(){
        List<User> userList = userService.findAll();
        if (userList == null){
            return new ResultVo(
                    false,
                    "没有数据",
                    null
            );
        }
        return new ResultVo(
                true,
                "查询成功",
                userList
        );
    }

    /**
     * 根据用户id查询User
     */
    @GetMapping("{id}")
    public ResultVo getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        if (user == null){
            return new ResultVo(false,"没有该用户",null);
        }
        return new ResultVo(
                true,
                "操作成功",
                user
        );
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping
    public ResultVo insertUser(@RequestBody User user){

        Integer rows = userService.insertUser(user);

        if (rows <= 0){
            return new ResultVo(false,"添加失败",null);
        }

        return new ResultVo(
                true,
                "添加成功",
                null
        );
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping("{user.id}")
    public ResultVo updateUser(@RequestBody User user){

        if (user == null){
            return new ResultVo(false,"修改失败",null);
        }

        Integer rows = userService.updateUser(user);

        if (rows <= 0){
            return new ResultVo(false,"修改失败",null);
        }

        return new ResultVo(
                true,
                "修改成功",
                null
        );

    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResultVo deleteUserById(@PathVariable Integer id){
        if (id == null){
            return new ResultVo(false,"删除失败",null);
        }
        Integer rows = userService.deleteUserById(id);
        if (rows <= 0){
            return new ResultVo(false,"删除失败",null);
        }
        return new ResultVo(
                true,
                "删除成功",
                null
        );
    }

}
