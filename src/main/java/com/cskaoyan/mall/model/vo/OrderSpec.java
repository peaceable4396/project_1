package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: OrderSpec
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 22:29
 * @version: 1.0
 */
public class OrderSpec {
    private Integer id;
    private String specName;
    private Double unitPrice;

    public OrderSpec() {
    }

    public OrderSpec(Integer id, String specName, Double price) {
        this.id = id;
        this.specName = specName;
        this.unitPrice = price;
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

    public Double getPrice() {
        return unitPrice;
    }

    public void setPrice(Double price) {
        this.unitPrice = price;
    }
}
