package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.dao.AdminDao;
import com.cskaoyan.mall.model.Admin;
import com.cskaoyan.mall.model.bo.*;
import com.cskaoyan.mall.model.vo.AdminInfoVo;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.service
 * @className: AdminServiceImpl
 * @author: sx
 * @description: TODO
 * @date: 2022/6/28 14:32
 * @version: 1.0
 */
public class AdminServiceImpl implements AdminService {
    @Override
    public int login(AdminLoginBo adminLoginBo) {
        Admin admin = new Admin();
        admin.setUsername(adminLoginBo.getEmail());
        admin.setPassword(adminLoginBo.getPassword());
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        int i = adminDao.queryCount(admin);
        sqlSession.commit();
        sqlSession.close();
        if (i == 0)
            return 404;
        return 200;
    }

    @Override
    public List<AdminInfoVo> allAdmins() {
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        List<AdminInfoVo> adminInfoVoList = adminDao.selectAllAdmins();
        sqlSession.commit();
        sqlSession.close();
        return adminInfoVoList;
    }

    @Override
    public int addAdmin(AdminAddBo adminAddBo) {
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        Admin admin = new Admin();
        admin.setUsername(adminAddBo.getEmail());
        admin.setNickname(adminAddBo.getNickname());
        AdminInfoVo adminInfoVo = adminDao.queryCountBYEmailorNickname(admin);

        if (adminInfoVo != null) {
            sqlSession.commit();
            sqlSession.close();
            return 10000;
        } else {
            adminDao.insertAdmin(adminAddBo);
            sqlSession.commit();
            sqlSession.close();
            return 0;
        }

    }

    @Override
    public List<AdminInfoVo> searchAdmin(AdminSearchBo adminSearchBo) {
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        List<AdminInfoVo> adminInfoVoList = adminDao.searchAdmin(adminSearchBo);
        sqlSession.commit();
        sqlSession.close();
        return adminInfoVoList;
    }

    @Override
    public void deletAdmins(Integer id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        adminDao.deletAdmin(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Integer getAdminId(AdminLoginBo adminLoginBo) {
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        Integer adminId = adminDao.getAdminId(adminLoginBo);
        sqlSession.commit();
        sqlSession.close();
        return adminId;
    }

    @Override
    public void updateAdmin(AdminUpdateBo adminUpdateBo) {
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        adminDao.updateAdmin(adminUpdateBo);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public AdminInfoVo getAdminById(int id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        AdminInfoVo adminById = adminDao.getAdminById(id);
        sqlSession.commit();
        sqlSession.close();
        return adminById;
    }

    @Override
    public String getPwdByUsername(String adminToken) {
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        String pwd = adminDao.getPwdByName(adminToken);
        sqlSession.commit();
        sqlSession.close();
        return pwd;
    }

    @Override
    public void changePwdByName(AdminChangePwdBo adminChangePwdBo) {
        SqlSession sqlSession = MybatisUtils.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        adminDao.changePwdByName(adminChangePwdBo);
        sqlSession.commit();
        sqlSession.close();
    }
}


