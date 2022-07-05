package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: UserAddBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 9:45
 * @version: 1.0
 */
public class UserSignupBo {
    private String address;
    private String email;
    private String nickname;
    private String phone;
    private String pwd;
    private String recipient;

    public UserSignupBo() {
    }

    public UserSignupBo(String address, String email, String nickname, String phone, String pwd, String recipient) {
        this.address = address;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.pwd = pwd;
        this.recipient = recipient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
