package com.cskaoyan.mall.controller.mall;

import com.cskaoyan.mall.model.bo.GetMsgBo;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet("/api/mall/goods/*")
public class MallGoodsServlet extends HttpServlet {
    GoodService goodService = new GoodServiceImpl();
    Gson gson = new Gson();
    UserService userService = new UserServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/mall/goods", "");
        if ("/getGoodsByType".equals(op)) {
            getGoodsByType(request, response);
        } else if ("/searchGoods".equals(op)) {
            searchGoods(request, response);
        } else if ("/getGoodsInfo".equals(op)) {
            getGoodsInfo(request, response);
        }else if ("/getGoodsMsg".equals(op)){
            getGoodsMsg(request,response);
        }else if ("/getGoodsComment".equals(op)){
            getGoodsComment(request,response);
        }
    }

    private void getGoodsComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idNum = request.getParameter("goodsId");
        Integer goodsId = Integer.parseInt(idNum);
        List<Comments> list = goodService.getCommentByGoodsId(goodsId);
        List<GetCommentsVo> commentList = new ArrayList<>();
        for (Comments comments : list) {
            GetCommentsVo getCommentsVo = new GetCommentsVo(comments.getComment(), comments.getId(), comments.getScore(), comments.getSpecName(), comments.getTime(),
                    new GetCommentUserVo(comments.getNickName()), comments.getUserId());
            commentList.add(getCommentsVo);
        }
        Double count = orderService.getOrderCountByGoodsId(goodsId);
        Double goodCount = orderService.getGoodOrderCountByGoodsId(goodsId);
        Double rate = goodCount / count * 100;
        GetCommentVo getCommentVo = new GetCommentVo(commentList, rate.toString());
        response.getWriter().println(gson.toJson(Result.ok(getCommentVo)));
    }

    private void getGoodsMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idNum = request.getParameter("id");
        Integer goodsId = Integer.parseInt(idNum);
        List<GoodMsg> msgList = goodService.getGoodMsgByGoodsId(goodsId);
        if (msgList == null){
            response.getWriter().println(gson.toJson(Result.ok()));
            return;
        }
        List<GetGoodsMessageVo> list = new ArrayList<>();
        for (GoodMsg goodsMsg : msgList) {
            GetGoodsMessageVo getGoodsMessageVo = new GetGoodsMessageVo(goodsMsg.getUsername(),goodsMsg.getContent(),goodsMsg.getId()
                    ,goodsMsg.getCreateTime(),new GetReplyVo(goodsMsg.getReplyContent(),goodsMsg.getReplyTime()));
            list.add(getGoodsMessageVo);
        }
        response.getWriter().println(gson.toJson(Result.ok(list)));
    }

    private void getGoodsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idNum = request.getParameter("id");
        Integer id = Integer.parseInt(idNum);
        List<SpecInfoVo> specs = goodService.getSpecsByGoodsId(id);
        GetGoodsInfo_GoodsVo goods = goodService.getGoodsById(id);
        if (specs.size() == 1)
            goods.setUnitPrice(specs.get(0).getUnitPrice());
        else {
            Optional<Double> reduce = specs.stream()
                    .map(SpecInfoVo::getUnitPrice)
                    .reduce(Double::min);
            reduce.ifPresent(goods::setUnitPrice);
        }
        GetMallGoodsInfoVo getMallGoodsInfoVo = new GetMallGoodsInfoVo(goods.getDesc(),goods.getImg(),goods.getName(),goods.getTypeId(),goods.getUnitPrice(),specs);
        response.getWriter().println(gson.toJson(Result.ok(getMallGoodsInfoVo)));
    }

    private void searchGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        List<Goods> list = goodService.getGoodsByName(keyword);
        if (list == null) {
            response.getWriter().println(gson.toJson(new Result(0, null, null)));
        } else {
            List<GetGoodsByNameVo> goodsList = new ArrayList<>();
            for (Goods good : list) {
                List<Spec> specs = goodService.getSpecByGoodsId(good.getId());
                Double price = 0.0;
                for (Spec spec : specs) {
                    price = Math.min(price, spec.getUnitPrice());
                }
                GetGoodsByNameVo getGoodsByNameVo = new GetGoodsByNameVo(good.getId(), good.getImg(), good.getName(), price, good.getTypeId());
                goodsList.add(getGoodsByNameVo);
            }
            response.getWriter().println(gson.toJson(Result.ok(goodsList)));
        }
    }


    private void getGoodsByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String typeIdNum = request.getParameter("typeId");
        int typeId = Integer.parseInt(typeIdNum);
        List<Goods> list = new ArrayList<>();
        if (typeId == -1) {
            list = goodService.getAllGoods();
        } else {
            list = goodService.getGoodByTypeId(typeId);
        }
        List<GetGoodsByTypeVo> getGoodsByTypeVoList = new ArrayList<>();
        for (Goods good : list) {
            List<Spec> specs = goodService.getSpecByGoodsId(good.getId());
            Double price = 0.0;
            Integer stockNum = 0;
            for (Spec spec : specs) {
                price += spec.getUnitPrice();
                stockNum += spec.getStockNum();
            }
            GetGoodsByTypeVo getGoodsByTypeVo = new GetGoodsByTypeVo(good.getId(), good.getImg(), price, good.getName(), good.getTypeId(), stockNum);
            getGoodsByTypeVoList.add(getGoodsByTypeVo);
        }
        response.getWriter().println(gson.toJson(Result.ok(getGoodsByTypeVoList)));
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/mall/goods", "");
        if ("/askGoodsMsg".equals(op)){
            askGoodsMsg(request,response);
        }
    }

    private void askGoodsMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetMsgBo getMsgBo = gson.fromJson(requestBody, GetMsgBo.class);
        String goodsId1 = getMsgBo.getGoodsId();
        Integer goodsId = Integer.parseInt(goodsId1);
        Date date = new Date();
        String time = Constant.DATE_FORMAT.format(date);
        GetGoodsInfo_GoodsVo goodsById = goodService.getGoodsById(goodsId);
        User user = userService.getUserByEmail(getMsgBo.getToken());
        GoodMsg goodsMsg = new GoodMsg(null,getMsgBo.getMsg(),null, goodsById.getName(),getMsgBo.getToken(),time,null,Constant.NO_REPLY,
                user.getId(),goodsId);
        goodService.addMsg(goodsMsg);
        response.getWriter().println(gson.toJson(Result.ok()));
    }
}
