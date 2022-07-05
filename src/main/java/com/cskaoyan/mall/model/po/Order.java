package com.cskaoyan.mall.model.po;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.po
 * @className: Order
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 22:54
 * @version: 1.0
 */
public class Order {
    private Double amount;
    private String goods;
    private Integer id;
    private String spec;
    private String state;
    private Integer stateId;
    private Integer userId;
    private String nickname;
    private String receiver;
    private String address;
    private String phone;
    private Integer goodsId;
    private Integer specId;
    private Integer number;
    private String createtime;
    private Integer score;
    private Boolean hasComment;

    public Order() {
    }

    public Order(Double amount, String goods, Integer id, String spec, String state, Integer stateId, Integer userId, String nickname, String receiver, String address, String phone, Integer goodsId, Integer specId, Integer number, String createtime, Integer score, Boolean hasComment) {
        this.amount = amount;
        this.goods = goods;
        this.id = id;
        this.spec = spec;
        this.state = state;
        this.stateId = stateId;
        this.userId = userId;
        this.nickname = nickname;
        this.receiver = receiver;
        this.address = address;
        this.phone = phone;
        this.goodsId = goodsId;
        this.specId = specId;
        this.number = number;
        this.createtime = createtime;
        this.score = score;
        this.hasComment = hasComment;
    }

    public Boolean getHasComment() {
        return hasComment;
    }

    public void setHasComment(Boolean hasComment) {
        this.hasComment = hasComment;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
