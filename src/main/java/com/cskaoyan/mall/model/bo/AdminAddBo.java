package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: AdminRegisteredBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/28 17:42
 * @version: 1.0
 */
public class AdminAddBo {
    private String nickname;
    private String email;
    private String pwd;

    public AdminAddBo() {
    }

    public AdminAddBo(String nickname, String email, String pwd) {
        this.nickname = nickname;
        this.email = email;
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
