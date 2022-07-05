package com.cskaoyan.mall.dao;

import com.cskaoyan.mall.model.po.GoodType;
import com.cskaoyan.mall.model.vo.HomepageGoodVo;

import java.util.List;

public interface MallDao {
    List<GoodType> getAllType();

    List<HomepageGoodVo> getAllHomepageGood();

}
