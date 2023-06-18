package com.auto.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultVo <T>{
    private boolean status;
    private String message;
    private T data;
}
