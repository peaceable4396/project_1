package com.cskaoyan.mall.model.po;

import com.cskaoyan.mall.utils.Constant;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: GoodByTypeVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 14:36
 * @version: 1.0
 */
public class Goods {
    private Integer id;
    private String desc;
    private String img;
    private String name;
    private Integer typeId;

    public Goods() {
    }

    public Goods(Integer id, String desc, String img, String name, Integer typeId) {
        this.id = id;
        this.desc = desc;
        this.img = img;
        this.name = name;
        this.typeId = typeId;
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
}
