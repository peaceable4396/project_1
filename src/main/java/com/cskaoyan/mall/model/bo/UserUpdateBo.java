package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: UserUpdateBo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 16:14
 * @version: 1.0
 */
public class UserUpdateBo {
    private String address;
    private String id;
    private String nickname;
    private String phone;
    private String recipient;

    public UserUpdateBo() {
    }

    public UserUpdateBo(String address, String id, String nickname, String phone, String recipient) {
        this.address = address;
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
        this.recipient = recipient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
