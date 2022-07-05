package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: DeleteSpecBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 20:25
 * @version: 1.0
 */
public class DeleteSpecBo {
    private String goodsId;
    private String specName;

    public DeleteSpecBo() {
    }

    public DeleteSpecBo(String goodsId, String specName) {
        this.goodsId = goodsId;
        this.specName = specName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
}
