package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.dao.MallUserDao;
import com.cskaoyan.mall.model.bo.UserSignupBo;
import com.cskaoyan.mall.model.bo.UserUpdateBo;
import com.cskaoyan.mall.model.po.User;
import com.cskaoyan.mall.service.MallUserService;
import com.cskaoyan.mall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.service.impl
 * @className: MallUserServiceImpl
 * @author: sx
 * @description: TODO
 * @date: 2022/6/30 9:42
 * @version: 1.0
 */
public class MallUserServiceImpl implements MallUserService {
    @Override
    public int addUser(UserSignupBo userSignupBo) {
        SqlSession sqlSession = MybatisUtils.openSession();
        MallUserDao mallUserDao = sqlSession.getMapper(MallUserDao.class);
        List<String> emails = mallUserDao.getAllUserEmails();
        if (emails.contains(userSignupBo.getEmail())){
            return 10000;
        }
        mallUserDao.addUser(userSignupBo);
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public String getUserByName(String email) {
        SqlSession sqlSession = MybatisUtils.openSession();
        MallUserDao mallUserDao = sqlSession.getMapper(MallUserDao.class);
        String pwd = mallUserDao.getUserByName(email);
        sqlSession.commit();
        sqlSession.close();
        return pwd;
    }

    @Override
    public User getUserByEmail(String email) {
        SqlSession sqlSession = MybatisUtils.openSession();
        MallUserDao mallUserDao = sqlSession.getMapper(MallUserDao.class);
        User user = mallUserDao.getUserByEmail(email);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public String getPwdByuserId(Integer userId) {
        SqlSession sqlSession = MybatisUtils.openSession();
        MallUserDao mallUserDao = sqlSession.getMapper(MallUserDao.class);
        String pwd = mallUserDao.getPwdByuserId(userId);
        sqlSession.commit();
        sqlSession.close();
        return pwd;
    }

    @Override
    public void changePwdByUserId(Integer userId, String newPwd) {
        SqlSession sqlSession = MybatisUtils.openSession();
        MallUserDao mallUserDao = sqlSession.getMapper(MallUserDao.class);
        mallUserDao.changePwdByUserId(userId,newPwd);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(UserUpdateBo userUpdateBo) {
        SqlSession sqlSession = MybatisUtils.openSession();
        MallUserDao mallUserDao = sqlSession.getMapper(MallUserDao.class);
        mallUserDao.updateUser(userUpdateBo);
        sqlSession.commit();
        sqlSession.close();
    }
}
