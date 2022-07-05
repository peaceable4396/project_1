package com.cskaoyan.mall.model.vo;

import com.cskaoyan.mall.model.po.Order;
import com.cskaoyan.mall.model.po.User;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetAllOrdersVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 23:02
 * @version: 1.0
 */
public class GetAllOrdersVo {
    private OrderUserVo user;
    private Double amount;
    private String goods;
    private Integer goodsDetailId;
    private Integer goodsNum;
    private Integer id;
    private String spec;
    private String state;
    private Integer stateId;
    private Integer userId;

    public GetAllOrdersVo() {
    }

    public GetAllOrdersVo(OrderUserVo user, Double amount, String goods, Integer goodsDetailId, Integer goodsNum, Integer id, String spec, String state, Integer stateId, Integer userId) {
        this.user = user;
        this.amount = amount;
        this.goods = goods;
        this.goodsDetailId = goodsDetailId;
        this.goodsNum = goodsNum;
        this.id = id;
        this.spec = spec;
        this.state = state;
        this.stateId = stateId;
        this.userId = userId;
    }

    public OrderUserVo getUser() {
        return user;
    }

    public void setUser(OrderUserVo user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
