package com.auto.exception;

import com.auto.en.ResultEntity;
import com.auto.vo.ResultVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常
 */
@RestControllerAdvice
public class AllHandlerException {

    /**
     * 系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResultVo systemHandlerException(Exception e){
        return new ResultVo(false, ResultEntity.FAIL_RESULT.getMessage(), "系统异常，请联系管理员！");
    }

    /**
     * 业务处理异常统一返回  自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultVo serviceHandlerException(Exception e){
        return new ResultVo(false,ResultEntity.FAIL_RESULT.getMessage(), "业务异常：" + e.getMessage());
    }

    /**
     * 用户相关异常
     */
    @ExceptionHandler(UserStatusException.class)
    public ResultVo userHandlerException(UserStatusException e){
        if (e.code == 401){
            return new ResultVo(false,ResultEntity.FAIL_RESULT.getMessage() , "用户相关：" + e.getMessage());
        }
        return null;
    }

}
