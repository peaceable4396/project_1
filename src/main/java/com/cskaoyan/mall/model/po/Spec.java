package com.cskaoyan.mall.model.po;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.po
 * @className: Spec
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 16:18
 * @version: 1.0
 */
public class Spec {
    private Integer id;
    private String specName;
    private Integer stockNum;
    private double unitPrice;
    private Integer goodsId;
    public Spec() {
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Spec(Integer id, String specName, Integer stockNum, double unitPrice, Integer goodsId) {
        this.id = id;
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
        this.goodsId = goodsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
