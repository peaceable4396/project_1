package com.cskaoyan.mall.model.vo;

import com.cskaoyan.mall.model.po.Spec;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetGoodsInfoVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 19:19
 * @version: 1.0
 */
public class GetGoodsInfoVo {
    GetGoodsInfo_GoodsVo goods;
    List<Spec> specs;

    public GetGoodsInfoVo() {
    }

    public GetGoodsInfoVo(GetGoodsInfo_GoodsVo goods, List<Spec> specs) {
        this.goods = goods;
        this.specs = specs;
    }

    public GetGoodsInfo_GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GetGoodsInfo_GoodsVo goods) {
        this.goods = goods;
    }

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }
}
