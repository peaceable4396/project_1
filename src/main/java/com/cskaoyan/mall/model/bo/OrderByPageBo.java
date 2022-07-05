package com.cskaoyan.mall.model.bo;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.bo
 * @className: OrderByPageBo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 22:33
 * @version: 1.0
 */
public class OrderByPageBo {
    private String address;
    private Integer currentPage;
    private String goods;
    private String id;
    private String moneyLimit1;
    private String moneyLimit2;
    private String name;
    private Integer pagesize;
    private Integer state;

    public OrderByPageBo() {
    }

    public OrderByPageBo(String address, Integer currentPage, String goods, String id, String moneyLimit1, String moneyLimit2, String name, Integer pagesize, Integer state) {
        this.address = address;
        this.currentPage = currentPage;
        this.goods = goods;
        this.id = id;
        this.moneyLimit1 = moneyLimit1;
        this.moneyLimit2 = moneyLimit2;
        this.name = name;
        this.pagesize = pagesize;
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoneyLimit1() {
        return moneyLimit1;
    }

    public void setMoneyLimit1(String moneyLimit1) {
        this.moneyLimit1 = moneyLimit1;
    }

    public String getMoneyLimit2() {
        return moneyLimit2;
    }

    public void setMoneyLimit2(String moneyLimit2) {
        this.moneyLimit2 = moneyLimit2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
