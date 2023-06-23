package com.auto.mapper;

import com.auto.pojo.Log;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {
    Integer insertLogInfo(Log log);
}
