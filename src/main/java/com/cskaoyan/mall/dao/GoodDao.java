package com.cskaoyan.mall.dao;

import com.cskaoyan.mall.model.bo.GetNoReplyMsgBo;
import com.cskaoyan.mall.model.bo.GoodsBo;
import com.cskaoyan.mall.model.po.*;
import com.cskaoyan.mall.model.redis.AllGoodNameId;
import com.cskaoyan.mall.model.redis.AllUserNameId;
import com.cskaoyan.mall.model.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodDao {
    List<GoodType> getAllType();

    List<Goods> getGoodByTypeId(Integer typeId);

    void addType(String name);

    void deleteType(Integer typeId);

    List<Spec> getSpecByGoodsId(Integer goodsId);

    void addGoods(Goods goods);

    void addSpec(@Param("spec") Spec spec, @Param("goodsId") int goodsId);

    void deleteGoods(Integer id);

    GetGoodsInfo_GoodsVo getGoodsById(Integer goodsId);

    void deletSpecs(Integer goodsId);

    void deletSpec(@Param("goodsId") int goodsId, @Param("specName") String specName);

    void updateGoods(Goods goods);

    void addSpecs(@Param("spec") Spec spec, @Param("goodsId") int goodsId);

    List<Goods> getAllGoods();

    List<Goods> getGoodsByName(String name);

    List<SpecInfoVo> getSpecsByGoodsId(Integer goodsId);


    List<AllUserNameId> getAllUserNameId();

    List<AllGoodNameId> getAllGoodNameId();

    Spec getSpecById(Integer specId);

    List<GoodMsg> getGoodMsgByStateId(int state);

    List<GoodMsg> getGoodMsgByGoodsId(Integer goodsId);

    void addMsg(GoodMsg goodsMsg);

    void updateMsg(@Param("getNoReplyMsgBo") GetNoReplyMsgBo getNoReplyMsgBo, @Param("time") String time, @Param("state") Integer state);

    List<Comments> getCommentByGoodsId(Integer goodsId);

    void updateSpec(@Param("id") Integer id, @Param("number") Integer number);

    void addComment(Comments comment);

}


