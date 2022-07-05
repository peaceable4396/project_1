package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.controller.mall
 * @className: OrderGoodsSpec
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 18:49
 * @version: 1.0
 */
public class OrderGoodsSpec {
    private String specName;
    private Integer specId;
    private Integer number;

    public OrderGoodsSpec() {
    }

    public OrderGoodsSpec(String specName, Integer specId, Integer number) {
        this.specName = specName;
        this.specId = specId;
        this.number = number;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
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
}
