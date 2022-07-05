package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: GoodsSpecBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 16:35
 * @version: 1.0
 */
public class GoodsSpecBo {
    private Integer goodsId;
    private String specName;
    private Integer stockNum;
    private Double unitPrice;

    public GoodsSpecBo() {
    }

    public GoodsSpecBo(Integer goodsId, String specName, Integer stockNum, Double unitPrice) {
        this.goodsId = goodsId;
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
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

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
