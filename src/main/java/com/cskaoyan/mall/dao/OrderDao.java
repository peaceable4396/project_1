package com.cskaoyan.mall.dao;

import com.cskaoyan.mall.model.bo.CartBo;
import com.cskaoyan.mall.model.bo.OrderByPageBo;
import com.cskaoyan.mall.model.po.Order;
import com.cskaoyan.mall.model.po.Spec;
import com.cskaoyan.mall.model.vo.OrderGoodsSpec;
import com.cskaoyan.mall.model.vo.SpecNameandUserVo;
import com.cskaoyan.mall.model.vo.States;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrder(OrderByPageBo order);

    Integer getOrdersCount(OrderByPageBo order);

    Order getOrderById(Integer id);


    void updateOrder(@Param("num") Integer num, @Param("spec") Spec spec, @Param("states") States states, @Param("id") Integer id, @Param("amount") Double amount);

    void deletOrderById(Integer id);

    void addOrder(Order order);

    List<Order> getOrderByStateIdandUser(@Param("stateId") Integer stateId, @Param("receiver") String receiver);

    void settleOrder(@Param("order") CartBo order, @Param("stateId") Integer stateId, @Param("state") String state);

    OrderGoodsSpec getOrderSpecById(Integer id);

    void updateState(@Param("id") Integer id, @Param("stateId") Integer stateId);

    List<Order> getOrderByUser(String receiver);

    SpecNameandUserVo getInfoByOrderId(Integer orderId);

    void changeOrderComment(@Param("orderId") Integer orderId, @Param("score") Integer score);

    Double getOrderCountByGoodsId(Integer goodsId);

    Double getGoodOrderCountByGoodsId(Integer goodsId);

}
