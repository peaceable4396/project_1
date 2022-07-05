package com.cskaoyan.mall.model.vo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: States
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 22:30
 * @version: 1.0
 */
public class States {
    private Integer id;
    private String name;
    public static States getStates(Integer i){
        if (i == 0){
            return new States(0,"未付款");
        }
        if (i == 1){
            return new States(1,"未发货");
        }
        if (i == 2){
            return new States(2,"已发货");
        }
        else {
            return new States(3,"已完成订单");
        }
    }


    public States() {
    }

    public States(Integer id, String name) {
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
