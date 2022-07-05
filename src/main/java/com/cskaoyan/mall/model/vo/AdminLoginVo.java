package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: AdminLoginVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/28 16:17
 * @version: 1.0
 */
public class AdminLoginVo {
    private String token;
    private String name;


    public AdminLoginVo() {
    }

    public AdminLoginVo(String username, String token) {
        this.token = token;
        this.name = username;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
