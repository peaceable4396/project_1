package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetUserDataVo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 15:47
 * @version: 1.0
 */
public class GetUserDataVo {
    private String address;
    private Integer code;
    private String email;
    private String id;
    private String nickname;
    private String phone;
    private String recipient;

    public GetUserDataVo() {
    }

    public GetUserDataVo(String address, Integer code, String email, String id, String nickname, String phone, String recipient) {
        this.address = address;
        this.code = code;
        this.email = email;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
