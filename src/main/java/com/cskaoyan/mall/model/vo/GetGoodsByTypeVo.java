package com.cskaoyan.mall.model.vo;

import com.cskaoyan.mall.utils.Constant;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetGoodsByTypeVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 18:58
 * @version: 1.0
 */
public class GetGoodsByTypeVo {
    private Integer id;
    private String img;
    private Double price;
    private String name;
    private Integer typeId;
    private Integer stockNum;

    public GetGoodsByTypeVo() {
    }

    public GetGoodsByTypeVo(Integer id, String img, Double price, String name, Integer typeId, Integer stockNum) {
        this.id = id;
        this.img = img;
        this.price = price;
        this.name = name;
        this.typeId = typeId;
        this.stockNum = stockNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = Constant.DOMAIN + img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }
}
