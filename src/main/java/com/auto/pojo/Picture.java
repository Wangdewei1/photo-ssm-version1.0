package com.auto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Picture {
    private Integer id;
    private String picName;
    private String content;
    private String imgPath;
    private Integer cid;
}
