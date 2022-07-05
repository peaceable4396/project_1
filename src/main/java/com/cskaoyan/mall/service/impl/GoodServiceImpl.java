package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.dao.GoodDao;
import com.cskaoyan.mall.model.bo.GetNoReplyMsgBo;
import com.cskaoyan.mall.model.bo.GoodsBo;
import com.cskaoyan.mall.model.po.*;
import com.cskaoyan.mall.model.redis.AllGoodNameId;
import com.cskaoyan.mall.model.redis.AllUserNameId;
import com.cskaoyan.mall.model.vo.*;
import com.cskaoyan.mall.service.GoodService;
import com.cskaoyan.mall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.service.impl
 * @className: GoodServiceImpl
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 14:29
 * @version: 1.0
 */
public class GoodServiceImpl implements GoodService {
    @Override
    public List<GoodType> getAllType() {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<GoodType> allType = goodDao.getAllType();
        sqlSession.commit();
        sqlSession.close();
        return allType;
    }

    @Override
    public List<Goods> getGoodByTypeId(Integer typeId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<Goods> list = goodDao.getGoodByTypeId(typeId);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public void addType(GoodType goodType) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.addType(goodType.getName());
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteType(Integer typeId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.deleteType(typeId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Spec> getSpecByGoodsId(Integer goodsId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<Spec> list = goodDao.getSpecByGoodsId(goodsId);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public int addGoods(Goods goods) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.addGoods(goods);
        sqlSession.commit();
        sqlSession.close();
        return goods.getId();
    }

    @Override
    public void addSpec(Spec spec) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.addSpec(spec,spec.getGoodsId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteGoods(Integer id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.deleteGoods(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public GetGoodsInfo_GoodsVo getGoodsById(Integer goodsId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        GetGoodsInfo_GoodsVo goods = goodDao.getGoodsById(goodsId);
        sqlSession.commit();
        sqlSession.close();
        return goods;
    }

    @Override
    public void deleteSpecs(Integer goodsId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.deletSpecs(goodsId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteSpec(Integer goodsId, String specName) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.deletSpec(goodsId,specName);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateGoods(Goods goods) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.updateGoods(goods);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void addSpecs(Spec spec, int goodsId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.addSpecs(spec,goodsId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Goods> getAllGoods() {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<Goods> list = goodDao.getAllGoods();
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<Goods> getGoodsByName(String name) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<Goods> list = goodDao.getGoodsByName(name);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<SpecInfoVo> getSpecsByGoodsId(Integer id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<SpecInfoVo> list = goodDao.getSpecsByGoodsId(id);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }


    @Override
    public List<AllUserNameId> getAllUserNameId() {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<AllUserNameId> list = goodDao.getAllUserNameId();
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<AllGoodNameId> getAllGoodNameId() {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<AllGoodNameId> list = goodDao.getAllGoodNameId();
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public Spec getSpecById(Integer specId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        Spec Spec = goodDao.getSpecById(specId);
        sqlSession.commit();
        sqlSession.close();
        return Spec;
    }

    @Override
    public List<GoodMsg> getGoodMsgByStateId(int state) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<GoodMsg> list = goodDao.getGoodMsgByStateId(state);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<GoodMsg> getGoodMsgByGoodsId(Integer goodsId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<GoodMsg> list = goodDao.getGoodMsgByGoodsId(goodsId);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public void addMsg(GoodMsg goodsMsg) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.addMsg(goodsMsg);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateMsg(GetNoReplyMsgBo getNoReplyMsgBo,String time,Integer state) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.updateMsg(getNoReplyMsgBo,time,state);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Comments> getCommentByGoodsId(Integer goodsId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        List<Comments> list = goodDao.getCommentByGoodsId(goodsId);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public void updateSpec(Integer id,Integer number) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.updateSpec(id,number);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void addComment(Comments comment) {
        SqlSession sqlSession = MybatisUtils.openSession();
        GoodDao goodDao = sqlSession.getMapper(GoodDao.class);
        goodDao.addComment(comment);
        sqlSession.commit();
        sqlSession.close();
    }


}
