package com.cskaoyan.mall.model.vo;

import com.cskaoyan.mall.model.po.Spec;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetMallGoodsInfoVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 11:54
 * @version: 1.0
 */
public class GetMallGoodsInfoVo {
    private String desc;
    private String img;
    private String name;
    private Integer typeId;
    private double unitPrice;
    List<SpecInfoVo> specs;

    public GetMallGoodsInfoVo() {
    }

    public GetMallGoodsInfoVo( String desc, String img, String name, Integer typeId, double unitPrice, List<SpecInfoVo> specs) {
        this.desc = desc;
        this.img = img;
        this.name = name;
        this.typeId = typeId;
        this.unitPrice = unitPrice;
        this.specs = specs;
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
        this.img = img;
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

    public List<SpecInfoVo> getSpecs() {
        return specs;
    }

    public void setSpecs(List<SpecInfoVo> specs) {
        this.specs = specs;
    }
}
