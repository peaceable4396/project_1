package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.dao.OrderDao;
import com.cskaoyan.mall.model.bo.CartBo;
import com.cskaoyan.mall.model.bo.OrderByPageBo;
import com.cskaoyan.mall.model.po.Order;
import com.cskaoyan.mall.model.po.Spec;
import com.cskaoyan.mall.model.vo.OrderGoodsSpec;
import com.cskaoyan.mall.model.vo.SpecNameandUserVo;
import com.cskaoyan.mall.model.vo.States;
import com.cskaoyan.mall.service.OrderService;
import com.cskaoyan.mall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.service.impl
 * @className: OrderServiceImpl
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 22:43
 * @version: 1.0
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> getAllOrders(OrderByPageBo order) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Order> list = orderDao.getAllOrder(order);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public Integer getOrdersCount(OrderByPageBo order) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        Integer total = orderDao.getOrdersCount(order);
        sqlSession.commit();
        sqlSession.close();
        return total;
    }

    @Override
    public Order getOrderById(Integer id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        Order order = orderDao.getOrderById(id);
        sqlSession.commit();
        sqlSession.close();
        return order;
    }

    @Override
    public void updateOrder(Integer num, Spec spec, States states,Integer id,Double amount) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDao.updateOrder(num,spec,states,id,amount);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deletOrderById(Integer id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDao.deletOrderById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void addOrder(Order order) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDao.addOrder(order);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Order> getOrderByStateIdandUser(Integer stateId, String receiver) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Order> list = orderDao.getOrderByStateIdandUser(stateId,receiver);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public void settleOrder(CartBo order, Integer stateId, String state) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDao.settleOrder(order,stateId,state);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public OrderGoodsSpec getOrderSpecById(Integer id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        OrderGoodsSpec goodsSpec = orderDao.getOrderSpecById(id);
        sqlSession.commit();
        sqlSession.close();
        return goodsSpec;
    }

    @Override
    public void updateState(Integer id,Integer stateId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDao.updateState(id,stateId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Order> getOrderByUser(String receiver) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Order> list = orderDao.getOrderByUser(receiver);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public SpecNameandUserVo getInfoByOrderId(Integer orderId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        SpecNameandUserVo info = orderDao.getInfoByOrderId(orderId);
        sqlSession.commit();
        sqlSession.close();
        return info;
    }

    @Override
    public void changeOrderComment(Integer orderId,Integer score) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDao.changeOrderComment(orderId,score);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Double getOrderCountByGoodsId(Integer goodsId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        Double count = orderDao.getOrderCountByGoodsId(goodsId);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    @Override
    public Double getGoodOrderCountByGoodsId(Integer goodsId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        Double count = orderDao.getGoodOrderCountByGoodsId(goodsId);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }


}
