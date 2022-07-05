package com.cskaoyan.mall.model.bo;

import com.cskaoyan.mall.model.po.Spec;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: GoodsUpdateBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 20:47
 * @version: 1.0
 */
public class GoodsUpdateBo {
    private Integer id;
    private String desc;
    private String img;
    private String name;
    private Integer typeId;
    private List<Spec> specList;

    public GoodsUpdateBo() {
    }

    public GoodsUpdateBo(Integer id, String desc, String img, String name, Integer typeId, List<Spec> specList) {
        this.id = id;
        this.desc = desc;
        this.img = img;
        this.name = name;
        this.typeId = typeId;
        this.specList = specList;
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

    public List<Spec> getSpecList() {
        return specList;
    }

    public void setSpecList(List<Spec> specList) {
        this.specList = specList;
    }
}
