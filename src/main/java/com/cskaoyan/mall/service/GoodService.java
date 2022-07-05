package com.cskaoyan.mall.service;

import com.cskaoyan.mall.model.bo.GetNoReplyMsgBo;
import com.cskaoyan.mall.model.bo.GoodsBo;
import com.cskaoyan.mall.model.po.*;
import com.cskaoyan.mall.model.redis.AllGoodNameId;
import com.cskaoyan.mall.model.redis.AllUserNameId;
import com.cskaoyan.mall.model.vo.*;

import java.util.List;

public interface GoodService {
    List<GoodType> getAllType();

    List<Goods> getGoodByTypeId(Integer typeId);

    void addType(GoodType goodType);

    void deleteType(Integer typeId);

    List<Spec> getSpecByGoodsId(Integer goodsId);

    int addGoods(Goods goods);

    void addSpec(Spec spec);

    void deleteGoods(Integer id);

    GetGoodsInfo_GoodsVo getGoodsById(Integer goodsId);

    void deleteSpecs(Integer goodsId);

    void deleteSpec(Integer goodsId, String specName);

    void updateGoods(Goods goods);

    void addSpecs(Spec spec, int goodsId);

    List<Goods> getAllGoods();

    List<Goods> getGoodsByName(String keyword);

    List<SpecInfoVo> getSpecsByGoodsId(Integer id);

    List<AllUserNameId> getAllUserNameId();

    List<AllGoodNameId> getAllGoodNameId();

    Spec getSpecById(Integer specId);

    List<GoodMsg> getGoodMsgByStateId(int state);

    List<GoodMsg> getGoodMsgByGoodsId(Integer goodsId);

    void addMsg(GoodMsg goodsMsg);

    void updateMsg(GetNoReplyMsgBo getNoReplyMsgBo,String time,Integer state);

    List<Comments> getCommentByGoodsId(Integer goodsId);

    void updateSpec(Integer id,Integer number);

    void addComment(Comments comment);

}
