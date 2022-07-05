package com.cskaoyan.mall.model.po;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: UserInfoVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 14:04
 * @version: 1.0
 */
public class User {
    private Integer id;
    private String email;
    private String address;
    private String nickname;
    private String phone;
    private String pwd;
    private String recipient;

    public User() {
    }

    public User(Integer id, String email, String address, String nickname, String phone, String pwd, String recipient) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.nickname = nickname;
        this.phone = phone;
        this.pwd = pwd;
        this.recipient = recipient;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
