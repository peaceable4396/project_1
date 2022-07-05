package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GetNoReplyGoods
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 15:16
 * @version: 1.0
 */
public class GetNoReplyGoodsVo {
    private String name;

    public GetNoReplyGoodsVo() {
    }

    public GetNoReplyGoodsVo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
