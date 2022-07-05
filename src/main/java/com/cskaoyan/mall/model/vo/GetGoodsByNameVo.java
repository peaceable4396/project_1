package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetGoodsByNameVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 11:19
 * @version: 1.0
 */
public class GetGoodsByNameVo {
    private Integer id;
    private String img;
    private String name;
    private Double price;
    private Integer typeId;

    public GetGoodsByNameVo() {
    }

    public GetGoodsByNameVo(Integer id, String img, String name, Double price, Integer typeId) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
