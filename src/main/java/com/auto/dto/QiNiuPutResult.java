package com.auto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QiNiuPutResult {
    private String key;
    private String hash;
    private String bucket;
    private int width;
    private int height;
}
