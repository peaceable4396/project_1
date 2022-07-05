package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: OrderUserVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 23:04
 * @version: 1.0
 */
public class OrderUserVo {
    private String address;
    private String name;
    private String nickname;
    private String phone;

    public OrderUserVo() {
    }

    public OrderUserVo(String address, String name, String nickname, String phone) {
        this.address = address;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
