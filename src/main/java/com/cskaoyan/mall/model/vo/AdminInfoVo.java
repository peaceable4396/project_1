package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: AllAdminsVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/28 17:10
 * @version: 1.0
 */
public class AdminInfoVo {
    private Integer id;
    private String email;
    private String nickname;
    private String pwd;

    public AdminInfoVo() {
    }

    public AdminInfoVo(Integer id, String email, String nickname, String pwd) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
