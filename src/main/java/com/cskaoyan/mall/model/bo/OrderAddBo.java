package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: OrderAddBo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 11:19
 * @version: 1.0
 */
public class OrderAddBo {
    private Double amount;
    private Integer goodsDetailId;
    private Integer num;
    private Integer state;
    private String token;

    public OrderAddBo() {
    }

    public OrderAddBo(Double amount, Integer goodsDetailId, Integer num, Integer state, String token) {
        this.amount = amount;
        this.goodsDetailId = goodsDetailId;
        this.num = num;
        this.state = state;
        this.token = token;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
