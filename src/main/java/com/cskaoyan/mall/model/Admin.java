package com.cskaoyan.mall.model;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model
 * @className: Admin
 * @author: sx
 * @description: TODO
 * @date: 2022/6/28 14:37
 * @version: 1.0
 */
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String nickname;

    public Admin() {
    }

    public Admin(Integer id, String username, String password, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
