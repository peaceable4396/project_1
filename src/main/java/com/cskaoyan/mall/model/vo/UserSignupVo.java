package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: UserSignupVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 10:06
 * @version: 1.0
 */
public class UserSignupVo {
    private Integer code;
    private String name;
    private String token;

    public UserSignupVo() {

    }

    public UserSignupVo(Integer code, String name, String token) {
        this.code = code;
        this.name = name;
        this.token = token;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
