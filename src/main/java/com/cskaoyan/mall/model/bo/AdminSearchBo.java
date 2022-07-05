package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: AdminSearchBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/28 19:38
 * @version: 1.0
 */
public class AdminSearchBo {
    private String nickname;
    private String email;

    public AdminSearchBo() {
    }

    public AdminSearchBo(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
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
}
