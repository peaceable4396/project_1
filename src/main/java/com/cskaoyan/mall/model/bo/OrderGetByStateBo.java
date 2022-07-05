package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: OrderGetByStateBo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 14:33
 * @version: 1.0
 */
public class OrderGetByStateBo {
    private String state;
    private String token;

    public OrderGetByStateBo() {
    }

    public OrderGetByStateBo(String state, String token) {
        this.state = state;
        this.token = token;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
