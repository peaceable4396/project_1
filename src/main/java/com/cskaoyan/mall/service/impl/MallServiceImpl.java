package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.dao.MallDao;
import com.cskaoyan.mall.model.po.GoodType;
import com.cskaoyan.mall.model.po.Goods;
import com.cskaoyan.mall.model.vo.HomepageGoodVo;
import com.cskaoyan.mall.service.MallService;
import com.cskaoyan.mall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.service.impl
 * @className: MallServiceImpl
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 10:21
 * @version: 1.0
 */
public class MallServiceImpl implements MallService {
    @Override
    public List<GoodType> getAllType() {
        SqlSession sqlSession = MybatisUtils.openSession();
        MallDao mallDao = sqlSession.getMapper(MallDao.class);
        List<GoodType> list = mallDao.getAllType();
        sqlSession.commit();
        sqlSession.close();
        return list;
    }




}
