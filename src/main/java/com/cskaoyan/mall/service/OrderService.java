package com.cskaoyan.mall.service;

import com.cskaoyan.mall.model.bo.CartBo;
import com.cskaoyan.mall.model.bo.OrderByPageBo;
import com.cskaoyan.mall.model.po.Order;
import com.cskaoyan.mall.model.po.Spec;
import com.cskaoyan.mall.model.vo.OrderGoodsSpec;
import com.cskaoyan.mall.model.vo.SpecNameandUserVo;
import com.cskaoyan.mall.model.vo.States;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders(OrderByPageBo orderByPageBo);

    Integer getOrdersCount(OrderByPageBo orderByPageBo);

    Order getOrderById(Integer id);


    void updateOrder(Integer num, Spec spec, States states,Integer id,Double amount);

    void deletOrderById(Integer id);

    void addOrder(Order order);

    List<Order> getOrderByStateIdandUser(Integer stateId, String receiver);

    void settleOrder(CartBo order, Integer id, String name);

    OrderGoodsSpec getOrderSpecById(Integer id);

    void updateState(Integer id,Integer stateId);

    List<Order> getOrderByUser(String receiver);

    SpecNameandUserVo getInfoByOrderId(Integer orderId);

    void changeOrderComment(Integer orderId,Integer score);

    Double getOrderCountByGoodsId(Integer goodsId);

    Double getGoodOrderCountByGoodsId(Integer goodsId);
}

