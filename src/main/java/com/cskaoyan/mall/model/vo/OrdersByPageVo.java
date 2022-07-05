package com.cskaoyan.mall.model.vo;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: OrdersByPageVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 23:36
 * @version: 1.0
 */
public class OrdersByPageVo {
    private List<GetAllOrdersVo> orders;
    private Integer total;

    public OrdersByPageVo() {
    }

    public OrdersByPageVo(List<GetAllOrdersVo> orders, Integer total) {
        this.orders = orders;
        this.total = total;
    }

    public List<GetAllOrdersVo> getOrders() {
        return orders;
    }

    public void setOrders(List<GetAllOrdersVo> orders) {
        this.orders = orders;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
