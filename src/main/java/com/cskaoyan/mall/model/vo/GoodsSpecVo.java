package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: GoodsSpecBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 16:35
 * @version: 1.0
 */
public class GoodsSpecVo {
    private String goodsId;
    private String specName;
    private String stockNum;
    private String unitPrice;

    public GoodsSpecVo() {
    }

    public GoodsSpecVo(String goodsId, String specName, String stockNum, String unitPrice) {
        this.goodsId = goodsId;
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
