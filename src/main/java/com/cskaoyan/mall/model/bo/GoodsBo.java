package com.cskaoyan.mall.model.bo;

import com.cskaoyan.mall.model.po.Spec;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GoodsInfoVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 16:22
 * @version: 1.0
 */
public class GoodsBo {
    private String desc;
    private String img;
    private String name;
    private List<Spec> specList;
    private Integer typeId;

    public GoodsBo() {

    }

    public GoodsBo(String desc, String img, String name, List<Spec> specList, Integer typeId) {
        this.desc = desc;
        this.img = img;
        this.name = name;
        this.specList = specList;
        this.typeId = typeId;
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

    public List<Spec> getSpecList() {
        return specList;
    }

    public void setSpecList(List<Spec> specList) {
        this.specList = specList;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
