package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: UserSignupBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 9:50
 * @version: 1.0
 */
public class UserLoginBo {
    private String email;
    private String pwd;

    public UserLoginBo() {
    }

    public UserLoginBo(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
