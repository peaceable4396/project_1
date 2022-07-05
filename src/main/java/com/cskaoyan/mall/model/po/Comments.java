package com.cskaoyan.mall.model.po;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.po
 * @className: Comments
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 14:05
 * @version: 1.0
 */
public class Comments {
    private Integer id;
    private String comment;
    private Integer score;
    private Integer goodsId;
    private String specName;
    private String time;
    private String nickName;
    private Integer userId;
    private Integer orderId;

    public Comments() {
    }

    public Comments(Integer id, String comment, Integer score, Integer goodsId, String specName, String time, String nickName, Integer userId, Integer orderId) {
        this.id = id;
        this.comment = comment;
        this.score = score;
        this.goodsId = goodsId;
        this.specName = specName;
        this.time = time;
        this.nickName = nickName;
        this.userId = userId;
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
