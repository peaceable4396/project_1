package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetOrderGoodsVo
 * @author: sx
 * @description: TODO
 * @date: 2022/7/1 15:07
 * @version: 1.0
 */
public class GetOrderGoodsVo {
    private Integer goodsDetailId;
    private Integer id;
    private String img;
    private String name;
    private String spec;
    private Double unitPrice;

    public GetOrderGoodsVo() {
    }

    public GetOrderGoodsVo(Integer goodsDetailId, Integer id, String img, String name, String spec, Double unitPrice) {
        this.goodsDetailId = goodsDetailId;
        this.id = id;
        this.img = img;
        this.name = name;
        this.spec = spec;
        this.unitPrice = unitPrice;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
