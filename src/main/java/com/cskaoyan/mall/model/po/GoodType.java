package com.cskaoyan.mall.model.po;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: GetTypeBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 10:23
 * @version: 1.0
 */
public class GoodType {
    private Integer id;
    private String name;

    public GoodType() {
    }

    public GoodType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
