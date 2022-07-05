package com.cskaoyan.mall.controller.mall;

import com.cskaoyan.mall.model.bo.CartBo;
import com.cskaoyan.mall.model.bo.CartsBo;
import com.cskaoyan.mall.model.bo.CommentSentBo;
import com.cskaoyan.mall.model.bo.OrderAddBo;
import com.cskaoyan.mall.model.po.*;
import com.cskaoyan.mall.model.vo.*;
import com.cskaoyan.mall.service.GoodService;
import com.cskaoyan.mall.service.OrderService;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.service.impl.GoodServiceImpl;
import com.cskaoyan.mall.service.impl.OrderServiceImpl;
import com.cskaoyan.mall.service.impl.UserServiceImpl;
import com.cskaoyan.mall.utils.Constant;
import com.cskaoyan.mall.utils.RequestBodyUtil;
import com.cskaoyan.mall.utils.Result;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/api/mall/order/*")
public class MallOrderServlet extends HttpServlet {
    Gson gson = new Gson();
    UserService userService = new UserServiceImpl();
    GoodService goodService = new GoodServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/mall/order", "");
        if ("/getOrderByState".equals(op)) {
            getOrderByState(request, response);
        } else if ("/deleteOrder".equals(op)) {
            deleteOrder(request, response);
        } else if ("/confirmReceive".equals(op)) {
            confirmReceive(request, response);
        }

    }

    private void confirmReceive(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idNum = request.getParameter("id");
        Integer id = Integer.parseInt(idNum);
        orderService.updateState(id, States.getStates(3).getId());
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idNum = request.getParameter("id");
        Integer id = Integer.parseInt(idNum);
        orderService.deletOrderById(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void getOrderByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String stateIdNum = request.getParameter("state");
        String receiver = request.getParameter("token");
        Integer stateId = Integer.parseInt(stateIdNum);
        List<Order> orderList = null;
        if (stateId == -1) {
            orderList = orderService.getOrderByUser(receiver);
        } else {
            orderList = orderService.getOrderByStateIdandUser(stateId, receiver);
        }
        List<Goods> goodsList = goodService.getAllGoods();
        List<GetOrderByStateVo> list = new ArrayList<>();
        Map<Integer, Goods> map = new HashMap<>();
        for (Goods goods : goodsList) {
            Integer goodsId = goods.getId();
            map.put(goodsId, goods);
        }
        for (Order order : orderList) {
            Integer goodsId = order.getGoodsId();
            Goods goods = map.get(goodsId);
            GetOrderByStateVo getOrderByStateVo = new GetOrderByStateVo(order.getAmount(), order.getCreatetime(), new GetOrderGoodsVo(order.getSpecId(),
                    order.getGoodsId(), goods.getImg(), goods.getName(), order.getSpec(), order.getAmount() / order.getNumber()), order.getSpecId(),
                    order.getNumber(), order.getHasComment(), order.getId(), order.getStateId());
            list.add(getOrderByStateVo);
        }
        response.getWriter().println(gson.toJson(Result.ok(list
                .stream()
                .sorted(Comparator.comparing(GetOrderByStateVo::getCreatetime)
                        .reversed())
                .collect(Collectors.toList()))));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/mall/order", "");
        if ("/addOrder".equals(op)) {
            addOrder(request, response);
        } else if ("/settleAccounts".equals(op)) {
            settleAccounts(request, response);
        } else if ("/sendComment".equals(op)) {
            sendComment(request, response);
        }
    }

    private void sendComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CommentSentBo commentSentBo = gson.fromJson(requestBody, CommentSentBo.class);
        Date date = new Date();
        String time = Constant.DATE_FORMAT.format(date);
        SpecNameandUserVo info = orderService.getInfoByOrderId(commentSentBo.getOrderId());
        Comments comment = new Comments(null, commentSentBo.getContent(), commentSentBo.getScore(), commentSentBo.getGoodsId(), info.getSpecName(),
                time, info.getNickName(), info.getUserId(), commentSentBo.getOrderId());
        goodService.addComment(comment);
        orderService.changeOrderComment(commentSentBo.getOrderId(),commentSentBo.getScore());
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void settleAccounts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CartsBo cartsBo = gson.fromJson(requestBody, CartsBo.class);
        List<CartBo> list = cartsBo.getList();
        for (CartBo order : list) {
            orderService.settleOrder(order, States.getStates(1).getId(), States.getStates(1).getName());
            OrderGoodsSpec orderSpec = orderService.getOrderSpecById(order.getId());
            Spec spec = goodService.getSpecById(orderSpec.getSpecId());
            int finnalNum = spec.getStockNum() - orderSpec.getNumber();
            if (finnalNum < 0) {
                response.getWriter().println(gson.toJson(Result.error("库存容量不够！")));
            }
            goodService.updateSpec(orderSpec.getSpecId(), finnalNum);
        }
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OrderAddBo orderAddBo = gson.fromJson(requestBody, OrderAddBo.class);
        User user = userService.getUserByEmail(orderAddBo.getToken());
        Spec spec = goodService.getSpecById(orderAddBo.getGoodsDetailId());
        GetGoodsInfo_GoodsVo goods = goodService.getGoodsById(spec.getGoodsId());
        Date date = new Date();
        String time = Constant.DATE_FORMAT.format(date);

        int finnalNum = spec.getStockNum() - orderAddBo.getNum();
        if (finnalNum < 0) {
            response.getWriter().println(gson.toJson(Result.error("库存容量不够！")));
        }
        goodService.updateSpec(spec.getId(), finnalNum);

        Order order = new Order(orderAddBo.getAmount(), goods.getName(), null, spec.getSpecName(), States.getStates(orderAddBo.getState()).getName(),
                orderAddBo.getState(), user.getId(), user.getNickname(), user.getEmail(), user.getAddress(), user.getPhone(), goods.getId(),
                spec.getId(), orderAddBo.getNum(), time, null, Constant.NO_COMMENT);

        orderService.addOrder(order);
        response.getWriter().println(gson.toJson(Result.ok()));
    }
}
