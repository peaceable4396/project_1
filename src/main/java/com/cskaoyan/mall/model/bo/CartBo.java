package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: CartBo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 17:46
 * @version: 1.0
 */
public class CartBo {
    private Double amount;
    private Integer goodsNum;
    private Integer id;

    public CartBo() {
    }

    public CartBo(Double amount, Integer goodsNum, Integer id) {
        this.amount = amount;
        this.goodsNum = goodsNum;
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
}
