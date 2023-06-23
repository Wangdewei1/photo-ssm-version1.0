package com.auto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log {
    private Integer logId;

    private String logName;

    private String logDate;
}
