package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: CommentSentBo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 20:06
 * @version: 1.0
 */
public class CommentSentBo {
    private String content;
    private Integer goodsDetailId;
    private Integer goodsId;
    private Integer orderId;
    private Integer score;
    private String token;

    public CommentSentBo() {
    }

    public CommentSentBo(String content, Integer goodsDetailId, Integer goodsId, Integer orderId, Integer score, String token) {
        this.content = content;
        this.goodsDetailId = goodsDetailId;
        this.goodsId = goodsId;
        this.orderId = orderId;
        this.score = score;
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
