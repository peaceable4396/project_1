package com.cskaoyan.mall.model.vo;

import com.cskaoyan.mall.model.po.Goods;

/**
 * @projectName:    project_1
 * @package:        com.cskaoyan.mall.controller.mall
 * @className:      GetOrderByStateVo
 * @author:     sx
 * @description:  TODO
 * @date:    2022/7/1 15:02
 * @version:    1.0
 */
public class GetOrderByStateVo {
    private Double amount;
    private String createtime;
    private GetOrderGoodsVo goods;
    private Integer goodsDetailId;
    private Integer goodsNum;
    private boolean hasComment;
    private Integer id;
    private Integer state;

    public GetOrderByStateVo() {
    }

    public GetOrderByStateVo(Double amount, String createtime, GetOrderGoodsVo goods, Integer goodsDetailId, Integer goodsNum, boolean hasComment, Integer id, Integer state) {
        this.amount = amount;
        this.createtime = createtime;
        this.goods = goods;
        this.goodsDetailId = goodsDetailId;
        this.goodsNum = goodsNum;
        this.hasComment = hasComment;
        this.id = id;
        this.state = state;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public GetOrderGoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GetOrderGoodsVo goods) {
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

    public boolean isHasComment() {
        return hasComment;
    }

    public void setHasComment(boolean hasComment) {
        this.hasComment = hasComment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
