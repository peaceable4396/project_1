package com.cskaoyan.mall.utils;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.utils
 * @className: result
 * @author: sx
 * @description: TODO
 * @date: 2022/6/28 16:02
 * @version: 1.0
 */
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static Result ok(){
        return ok(null);
    }

    public static Result ok(Object data){
        return new Result(0, null, data);
    }

    public static Result error(String message){
        return new Result(10000, message, null);
    }
}
