package com.cskaoyan.mall.controller.admin;

import com.cskaoyan.mall.dao.UserDao;
import com.cskaoyan.mall.model.bo.*;
import com.cskaoyan.mall.model.po.GoodMsg;
import com.cskaoyan.mall.model.po.GoodType;
import com.cskaoyan.mall.model.po.Goods;
import com.cskaoyan.mall.model.po.Spec;
import com.cskaoyan.mall.model.redis.AllGoodNameId;
import com.cskaoyan.mall.model.redis.AllUserNameId;
import com.cskaoyan.mall.model.vo.*;
import com.cskaoyan.mall.service.GoodService;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.service.impl.GoodServiceImpl;
import com.cskaoyan.mall.service.impl.UserServiceImpl;
import com.cskaoyan.mall.utils.*;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/api/admin/goods/*")
public class GoodsServlet extends HttpServlet {
    GoodService goodService = new GoodServiceImpl();
    Gson gson = new Gson();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/admin/goods", "");
        if ("/getType".equals(op)) {
            getType(request, response);
        } else if ("/getGoodsByType".equals(op)) {
            getGoodsByType(request, response);
        } else if ("/deleteType".equals(op)) {
            deleteType(request, response);
        } else if ("/deleteGoods".equals(op)) {
            deleteGoods(request, response);
        } else if ("/getGoodsInfo".equals(op)) {
            getGoodsInfo(request, response);
        } else if ("/noReplyMsg".equals(op)) {
            noReplyMsg(request, response);
        } else if ("/repliedMsg".equals(op)) {
            repliedMsg(request, response);
        }
    }

    private void repliedMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int state = Constant.REPLIED;
        List<GetRepliedMsgBo> repliedMsgBos = new ArrayList<>();
        List<GoodMsg> msgList = goodService.getGoodMsgByStateId(state);
        for (GoodMsg goodMsg : msgList) {
            GetRepliedMsgBo msgVo = new GetRepliedMsgBo(goodMsg.getContent(), goodMsg.getCreateTime(), new GetNoReplyGoodsVo(goodMsg.getGoods()),
                    goodMsg.getGoodsId(), goodMsg.getId(), goodMsg.getReplyContent(), state, new GetNoReplyUserVo(goodMsg.getUsername()), goodMsg.getUserId());
            repliedMsgBos.add(msgVo);
        }
        response.getWriter().println(gson.toJson(Result.ok(repliedMsgBos)));
    }


    private void noReplyMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int state = Constant.NO_REPLY;
        List<GetNoReplyMsgVo> replyMsgVoList = new ArrayList<>();
        List<GoodMsg> msgList = goodService.getGoodMsgByStateId(state);
        for (GoodMsg goodMsg : msgList) {
            GetNoReplyMsgVo msgVo = new GetNoReplyMsgVo(goodMsg.getContent(), goodMsg.getCreateTime(), goodMsg.getGoodsId(), goodMsg.getId(), goodMsg.getState(),
                    goodMsg.getUserId(), new GetNoReplyGoodsVo(goodMsg.getGoods()), new GetNoReplyUserVo(goodMsg.getUsername()));
            replyMsgVoList.add(msgVo);
        }
        response.getWriter().println(gson.toJson(Result.ok(replyMsgVoList)));
    }


    private void getGoodsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            response.getWriter().println(gson.toJson(Result.error("不能为空")));
        }
        Integer goodsId = Integer.parseInt(id);
        List<Spec> specs = goodService.getSpecByGoodsId(goodsId);
        GetGoodsInfo_GoodsVo goods = goodService.getGoodsById(goodsId);
        if (specs.size() == 1)
            goods.setUnitPrice(specs.get(0).getUnitPrice());
        else {
            Optional<Double> reduce = specs.stream()
                    .map(Spec::getUnitPrice)
                    .reduce(Double::min);
            reduce.ifPresent(goods::setUnitPrice);
        }
        GetGoodsInfoVo getGoodsInfoVo = new GetGoodsInfoVo(goods, specs);
        response.getWriter().println(gson.toJson(Result.ok(getGoodsInfoVo)));
    }

    //删除商品
    private void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            response.getWriter().println(gson.toJson(Result.error("不能为空")));
        }
        Integer goodsId = Integer.parseInt(id);
        goodService.deleteGoods(goodsId);
        goodService.deleteSpecs(goodsId);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    //删除类目
    private void deleteType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("typeId");
        Integer typeId = Integer.parseInt(id);
        goodService.deleteType(typeId);
        response.getWriter().println(gson.toJson(new Result(0, null, null)));
    }

    //商品管理首页
    private void getGoodsByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String typeIdNum = request.getParameter("typeId");
        if (StringUtils.isEmpty(typeIdNum)) {
            response.getWriter().println(gson.toJson(Result.error("不能为空")));
        }
        Integer typeId = Integer.parseInt(typeIdNum);
        List<Goods> list = goodService.getGoodByTypeId(typeId);
        response.getWriter().println(gson.toJson(new Result(0, null, list)));
    }

    //获取所有类目
    private void getType(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<GoodType> list = goodService.getAllType();
        response.getWriter().println(gson.toJson(new Result(0, null, list)));
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String op = requestURI.replace(request.getContextPath() + "/api/admin/goods", "");
        if ("/addType".equals(op)) {
            addType(request, response);
        } else if ("/imgUpload".equals(op)) {
            imgUpload(request, response);
        } else if ("/addGoods".equals(op)) {
            addGoods(request, response);
        } else if ("/addSpec".equals(op)) {
            addSpec(request, response);
        } else if ("/deleteSpec".equals(op)) {
            deleteSpec(request, response);
        } else if ("/updateGoods".equals(op)) {
            updateGoods(request, response);
        } else if ("/reply".equals(op)) {
            reply(request, response);
        }
    }

    private void reply(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetNoReplyMsgBo getNoReplyMsgBo = gson.fromJson(requestBody, GetNoReplyMsgBo.class);
        if (StringUtils.isEmpty(getNoReplyMsgBo.getContent())) {
            response.getWriter().println(gson.toJson(Result.error("回复不能为空")));
        }
        Date date = new Date();
        String time = Constant.DATE_FORMAT.format(date);

        goodService.updateMsg(getNoReplyMsgBo, time, Constant.REPLIED);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void updateGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        GoodsUpdateBo goodsUpdateBo = null;
        try {
            requestBody = RequestBodyUtil.get(request);
            goodsUpdateBo = gson.fromJson(requestBody, GoodsUpdateBo.class);
        } catch (Exception e) {
            response.getWriter().println(gson.toJson(Result.error("商品参数错误")));
            return;
        }
        String name = goodsUpdateBo.getName();
        Integer id = goodsUpdateBo.getId();
        if (StringUtils.isEmpty(name) || goodsUpdateBo.getSpecList() == null) {
            response.getWriter().println(gson.toJson(Result.error("商品信息不完整")));
            return;
        }
        Goods goods = new Goods(null, goodsUpdateBo.getDesc(), goodsUpdateBo.getImg(), name, goodsUpdateBo.getTypeId());
        List<Goods> list = goodService.getGoodByTypeId(goodsUpdateBo.getTypeId());
        if (list.stream()
                .filter(d -> !d.getId().equals(id))
                .anyMatch(a -> {
                    return a.getName().equals(goods.getName());
                })) {
            response.getWriter().println(gson.toJson(Result.error("商品名不能重复！")));
            return;
        }
        goodService.updateGoods(goods);
        response.getWriter().println(gson.toJson(Result.ok()));
    }


    private void deleteSpec(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DeleteSpecBo deleteSpecBo = gson.fromJson(requestBody, DeleteSpecBo.class);
        String goodsIdNum = deleteSpecBo.getGoodsId();
        int goodsId = Integer.parseInt(goodsIdNum);
        String specName = deleteSpecBo.getSpecName();
        goodService.deleteSpec(goodsId, specName);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void addSpec(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        GoodsSpecBo goodsSpecBo = null;
        try {
            requestBody = RequestBodyUtil.get(request);
            goodsSpecBo = gson.fromJson(requestBody, GoodsSpecBo.class);
        } catch (Exception e) {
            response.getWriter().println(gson.toJson(Result.error("规格参数错误")));
            return;
        }

        String specName = goodsSpecBo.getSpecName();
        Integer stockNum = goodsSpecBo.getStockNum();
        Double unitPrice = goodsSpecBo.getUnitPrice();
        Integer goodsId = goodsSpecBo.getGoodsId();
        if (StringUtils.isEmpty(specName)) {
            response.getWriter().println(gson.toJson(Result.error("规格名称不能为空")));
        } else {
            List<Spec> list = goodService.getSpecByGoodsId(goodsId);
            if (list.stream().anyMatch(a -> {
                return specName.equals(a.getSpecName());
            })) {
                response.getWriter().println(gson.toJson(Result.error("规格名称不能重复")));
            } else {
                Spec spec = new Spec(null, specName, stockNum, unitPrice, goodsId);
                goodService.addSpec(spec);
                response.getWriter().println(gson.toJson(Result.ok(goodsSpecBo)));
            }
        }
    }

    private void addGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        GoodsBo goodsBo = null;
        try {
            requestBody = RequestBodyUtil.get(request);
            goodsBo = gson.fromJson(requestBody, GoodsBo.class);
        } catch (Exception e) {
            response.getWriter().println(gson.toJson(Result.error("商品参数错误")));
            return;
        }
        Goods goods = new Goods(null, goodsBo.getDesc(), goodsBo.getImg(), goodsBo.getName(), goodsBo.getTypeId());
        List<Goods> list = goodService.getGoodByTypeId(goodsBo.getTypeId());
        if (list.stream().anyMatch(a -> {
            return goods.getName().equals(a.getName());
        })) {
            response.getWriter().println(gson.toJson(Result.error("商品不能重复")));
            return;
        }

        List<Spec> specList = goodsBo.getSpecList();
        List<String> specList1 = specList.stream()
                .map(Spec::getSpecName)
                .distinct()
                .collect(Collectors.toList());
        if (specList.size() != specList1.size()) {
            response.getWriter().println(gson.toJson(Result.error("商品规格重复")));
        } else {
            int goodsId = goodService.addGoods(goods);
            for (Spec spec : specList) {
                goodService.addSpecs(spec, goodsId);
            }
            response.getWriter().println(gson.toJson(Result.ok()));
        }


    }

    private void imgUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> map = FileUploadUtils.parseReqeuest(request);
        String file = map.get("file");
        response.getWriter().println(gson.toJson(Result.ok(file)));
    }

    //增加商品类目
    private void addType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = null;
        try {
            requestBody = RequestBodyUtil.get(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GoodType goodType = gson.fromJson(requestBody, GoodType.class);
        List<GoodType> list = goodService.getAllType();
        boolean b = list.stream().anyMatch(a -> {
            return goodType.getName().equals(a.getName());
        });
        if (StringUtils.isEmpty(goodType.getName())) {
            response.getWriter().println(gson.toJson(new Result(10000, "类目名不能为空", null)));
        } else if (b) {
            response.getWriter().println(gson.toJson(new Result(10000, "类目名不能重复", null)));
        } else {
            goodService.addType(goodType);
            response.getWriter().println(gson.toJson(new Result(0, null, null)));
        }
    }
}
