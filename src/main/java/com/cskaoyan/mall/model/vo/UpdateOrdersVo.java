package com.cskaoyan.mall.model.vo;


import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.model.vo
 * @className: UpdateOrdersVo
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 22:24
 * @version: 1.0
 */
public class UpdateOrdersVo {
    private Double amount;
    private CurSpec curSpec;
    private CurState curState;
    private String goods;
    private Integer goodsDetailId;
    private Integer id;
    private Integer num;
    private List<OrderSpec> specs;
    private Integer state;
    private List<States> states;

    public UpdateOrdersVo() {
    }

    public UpdateOrdersVo(Double amount, CurSpec curSpec, CurState curState, String goods, Integer goodsDetailId, Integer id, Integer num, List<OrderSpec> specs, Integer state, List<States> states) {
        this.amount = amount;
        this.curSpec = curSpec;
        this.curState = curState;
        this.goods = goods;
        this.goodsDetailId = goodsDetailId;
        this.id = id;
        this.num = num;
        this.specs = specs;
        this.state = state;
        this.states = states;
    }

    public CurSpec getCurSpec() {
        return curSpec;
    }

    public void setCurSpec(CurSpec curSpec) {
        this.curSpec = curSpec;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CurState getCurState() {
        return curState;
    }

    public void setCurState(CurState curState) {
        this.curState = curState;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<OrderSpec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<OrderSpec> specs) {
        this.specs = specs;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<States> getStates() {
        return states;
    }

    public void setStates(List<States> states) {
        this.states = states;
    }
}
