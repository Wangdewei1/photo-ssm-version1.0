package com.auto.en;

/**
 * 返回 JSON数据状态
 */
public enum ResultEntity{
    SUCCESS_RESULT (true,200,"操作成功"),
    FAIL_RESULT(false,401,"操作失败",null);
    Integer code;
    String message;
    Boolean status;
    Object data;

    /**
     * 操作成功
     * @param status
     * @param code
     * @param message
     */
    ResultEntity(Boolean status,Integer code, String message,Object data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    ResultEntity(Boolean status,Integer code, String message){
        this.code = code;
        this.message = message;
        this.status = status;
    }

    ResultEntity(){

    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }
}
