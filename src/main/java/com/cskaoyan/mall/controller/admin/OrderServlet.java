package com.cskaoyan.mall.controller.admin;

import com.cskaoyan.mall.model.bo.OrderByPageBo;
import com.cskaoyan.mall.model.bo.OrderUpdateBo;
import com.cskaoyan.mall.model.po.Order;
import com.cskaoyan.mall.model.po.Spec;
import com.cskaoyan.mall.model.po.User;
import com.cskaoyan.mall.model.vo.*;
import com.cskaoyan.mall.service.GoodService;
import com.cskaoyan.mall.service.OrderService;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.service.impl.GoodServiceImpl;
import com.cskaoyan.mall.service.impl.OrderServiceImpl;
import com.cskaoyan.mall.service.impl.UserServiceImpl;
import com.cskaoyan.mall.utils.RequestBodyUtil;
import com.cskaoyan.mall.utils.Result;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/admin/order/*")
public class OrderServlet extends HttpServlet {
    Gson gson = new Gson();
    OrderService orderService = new OrderServiceImpl();
    GoodService goodService = new GoodServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/admin/order", "");
        if ("/ordersByPage".equals(op)) {
            ordersByPage(request, response);
        }else if ("/order".equals(op)){
            order(request,response);
        }else if ("/deleteOrder".equals(op)){
            deleteOrder(request,response);
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String parameter = request.getParameter("id");
        Integer id = Integer.parseInt(parameter);
        orderService.deletOrderById(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void order(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String parameter = request.getParameter("id");
        Integer id = Integer.parseInt(parameter);
        Order order = orderService.getOrderById(id);
        List<OrderSpec> specList = new ArrayList<>();
        List<Spec> specByGoodsId = goodService.getSpecByGoodsId(order.getGoodsId());
        for (Spec spec : specByGoodsId) {
            specList.add(new OrderSpec(spec.getId(),spec.getSpecName(),spec.getUnitPrice()));
        }
        List<States> statesList = new ArrayList<>();
        statesList.add(States.getStates(0));
        statesList.add(States.getStates(1));
        statesList.add(States.getStates(2));
        statesList.add(States.getStates(3));
        UpdateOrdersVo updateOrdersVo = new UpdateOrdersVo(order.getAmount(),new CurSpec(order.getSpecId()),new CurState(order.getStateId()),order.getGoods(),order.getSpecId()
        ,order.getId(),order.getNumber(),specList,order.getStateId(),statesList);
        response.getWriter().println(gson.toJson(Result.ok(updateOrdersVo)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/admin/order", "");
        if ("/ordersByPage".equals(op)) {
            ordersByPage(request, response);
        }else if ("/changeOrder".equals(op)){
            changeOrder(request,response);
        }

    }

    private void changeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OrderUpdateBo orderUpdateBo = gson.fromJson(requestBody, OrderUpdateBo.class);
        String orderUpdateBoId = orderUpdateBo.getId();
        Integer id = Integer.parseInt(orderUpdateBoId);
        Integer num = orderUpdateBo.getNum();
        Integer specId = orderUpdateBo.getSpec();
        Integer stateId = orderUpdateBo.getState();
        Spec spec = goodService.getSpecById(specId);
        States states = States.getStates(stateId);
        Double amount = num * spec.getUnitPrice();
        orderService.updateOrder(num,spec,states,id,amount);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void ordersByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OrderByPageBo orderByPageBo = gson.fromJson(requestBody, OrderByPageBo.class);
        List<Order> orderList = orderService.getAllOrders(orderByPageBo);
        Integer total = orderService.getOrdersCount(orderByPageBo);
        List<GetAllOrdersVo> ordersVoList = new ArrayList<>();
        for (Order order : orderList) {
            GetAllOrdersVo orderVo = new GetAllOrdersVo(new OrderUserVo(order.getAddress(),order.getReceiver(),order.getNickname(),order.getPhone())
                    ,order.getAmount(),order.getGoods(),order.getSpecId(),order.getNumber(),order.getId(),order.getSpec(),order.getState()
                    ,order.getStateId(),order.getUserId());
            ordersVoList.add(orderVo);
        }
        OrdersByPageVo ordersByPageVo = new OrdersByPageVo(ordersVoList, total);
        response.getWriter().println(gson.toJson(Result.ok(ordersByPageVo)));
    }
}
