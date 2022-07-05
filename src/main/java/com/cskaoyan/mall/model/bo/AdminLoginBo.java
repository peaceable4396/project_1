package com.cskaoyan.mall.model.bo;

public class AdminLoginBo {
    private String email;
    private String pwd;

    public AdminLoginBo() {
    }

    public AdminLoginBo(String username, String password) {
        this.email = username;
        this.pwd = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String password) {
        this.pwd = password;
    }
}
