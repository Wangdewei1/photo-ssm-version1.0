package com.auto.controller;

import com.auto.en.ResultEntity;
import com.auto.exception.UserStatusException;
import com.auto.gruop.ValidatedGroup;
import com.auto.pojo.User;
import com.auto.service.UserService;
import com.auto.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public ResultVo login(@RequestBody User user) throws UserStatusException {
        //登录
        User userLogin = userService.getUserByUsernameAndPassword(user);

        if (userLogin == null){
            throw new UserStatusException(401,"登陆失败，用户不存在！");
        }

        return new ResultVo(
                true,
                "登陆成功",
                userLogin
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
    public ResultVo insertUser(@Validated(ValidatedGroup.InsertGroup.class) @RequestBody User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            List<String> list = bindingResult.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
            String errorMsg = list.get(0);
            return new ResultVo(false,"操作失败",errorMsg);
        }

        Integer rows = userService.insertUser(user);

        if (rows <= 0){
            return new ResultVo(false,"添加失败", ResultEntity.FAIL_RESULT.getData());
        }

        return new ResultVo(
                true,
                "添加成功",
                null
        );
    }

    /**
     * 更新用户
     * @param
     * @return
     */
    @PutMapping("{id}")
    public ResultVo updateUser(@NotNull(message = "用户id不能为空") @PathVariable Integer id ,
                               @Validated(ValidatedGroup.UpdateGroup.class) @RequestBody User user,
                               BindingResult bindingResult
                               ){

        if (bindingResult.hasErrors()){
            List<String> list = bindingResult.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
            String errorMsg = list.get(0);
            return new ResultVo(false,"操作失败",errorMsg);
        }

        Integer rows = userService.updateUser(id,user.getUsername(),user.getPwd());

        if (rows <= 0){
            return new ResultVo(false,"修改失败",null);
        }

        //查询修改后的用户
        User updateUser = userService.getUserById(id);

        return new ResultVo(
                true,
                "修改成功",
                updateUser
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
