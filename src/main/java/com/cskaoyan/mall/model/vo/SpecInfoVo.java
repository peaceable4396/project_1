package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: SpecInfoVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 11:50
 * @version: 1.0
 */
public class SpecInfoVo {
    private Integer id;
    private String specName;
    private Integer stockNum;
    private Double unitPrice;

    public SpecInfoVo() {
    }

    public SpecInfoVo(Integer id, String specName, Integer stockNum, Double unitPrice) {
        this.id = id;
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
