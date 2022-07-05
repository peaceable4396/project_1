package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: HomeGoodVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 10:53
 * @version: 1.0
 */
public class HomepageGoodVo {
    private Integer id;
    private String img;
    private String name;
    private Integer price;
    private Integer stockNum;
    private Integer typeId;

    public HomepageGoodVo() {
    }

    public HomepageGoodVo(Integer id, String img, String name, Integer price, Integer stockNum, Integer typeId) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.stockNum = stockNum;
        this.typeId = typeId;
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
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
