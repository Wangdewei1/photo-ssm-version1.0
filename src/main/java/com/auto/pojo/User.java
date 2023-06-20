package com.auto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;//用户id
    private String username;//用户姓名
    private String pwd;//用户密码

}
