package com.cskaoyan.mall.model.vo;

import com.cskaoyan.mall.utils.Constant;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetGoodsInfo_GoodsVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 19:20
 * @version: 1.0
 */
public class GetGoodsInfo_GoodsVo {
    private Integer id;
    private String desc;
    private String img;
    private String name;
    private Integer typeId;
    private double unitPrice;

    public GetGoodsInfo_GoodsVo() {
    }

    public GetGoodsInfo_GoodsVo(Integer id, String desc, String img, String name, Integer typeId, double unitPrice) {
        this.id = id;
        this.desc = desc;
        this.img = img;
        this.name = name;
        this.typeId = typeId;
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = Constant.DOMAIN + img;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
