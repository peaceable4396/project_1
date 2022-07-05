package com.cskaoyan.mall.model.redis;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.redis
 * @className: AllGoodNameId
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 19:45
 * @version: 1.0
 */
public class AllGoodNameId {
    private String name;
    private String goodsId;

    public AllGoodNameId() {
    }

    public AllGoodNameId(String name, String goodsId) {
        this.name = name;
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
