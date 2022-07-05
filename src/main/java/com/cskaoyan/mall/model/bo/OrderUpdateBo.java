package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: OrderUpdateBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 23:21
 * @version: 1.0
 */
public class OrderUpdateBo {
    private String id;
    private Integer num;
    private Integer spec;
    private Integer state;

    public OrderUpdateBo() {
    }

    public OrderUpdateBo(String id, Integer num, Integer spec, Integer state) {
        this.id = id;
        this.num = num;
        this.spec = spec;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSpec() {
        return spec;
    }

    public void setSpec(Integer spec) {
        this.spec = spec;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
