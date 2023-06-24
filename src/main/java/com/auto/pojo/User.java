package com.auto.pojo;

import com.auto.gruop.ValidatedGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * 用户实体类
 * 权限校验
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Null(groups = ValidatedGroup.InsertGroup.class , message = "账户id必须为空")
    @NotNull(groups = ValidatedGroup.UpdateGroup.class , message = "账户id必须不为空")
    private Integer id;//用户id

    @NotBlank(groups = {ValidatedGroup.UpdateGroup.class,ValidatedGroup.InsertGroup.class} , message = "用户名不能为空")
    @Size(groups = {ValidatedGroup.UpdateGroup.class,ValidatedGroup.InsertGroup.class} ,max = 10 , min = 4 ,message = "用户名长度4 - 10位")
    private String username;//用户姓名

    @NotBlank(groups = {ValidatedGroup.UpdateGroup.class,ValidatedGroup.InsertGroup.class},message = "密码不能为空")
    @Size(groups = {ValidatedGroup.UpdateGroup.class,ValidatedGroup.InsertGroup.class} ,min = 8,max = 16,message = "密码长度必须在 8 - 16 位")
//    @Min(value = 8 , message = "用户名不能小于8位")
//    @Max(value = 16 , message = "用户名不能大于16位")
    //min和max属性必须为数值
    private String pwd;//用户密码


}
