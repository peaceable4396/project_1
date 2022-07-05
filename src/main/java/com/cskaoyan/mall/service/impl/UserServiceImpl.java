package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.dao.UserDao;
import com.cskaoyan.mall.model.po.User;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.service.impl
 * @className: UserServiceImpl
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 9:49
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUser() {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.getAllUser();
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<User> searchUser(String word) {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.searchUser(word);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public void deletUserById(int id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deletUserById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User getUserByEmail(String email) {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserByEmail(email);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

}
