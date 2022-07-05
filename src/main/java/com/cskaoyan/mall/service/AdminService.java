package com.cskaoyan.mall.service;

import com.cskaoyan.mall.model.bo.*;
import com.cskaoyan.mall.model.vo.AdminInfoVo;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.service
 * @className: AdminService
 * @author: sx
 * @description: 返回id为登录成功，-1为登录失败
 * @date: 2022/6/28 14:32
 * @version: 1.0
 */
public interface AdminService {
    int login(AdminLoginBo adminLoginBo);

    List<AdminInfoVo> allAdmins();
    //返回0表示创建成功，10000表示重复
    int addAdmin(AdminAddBo adminAddBo);

    List<AdminInfoVo> searchAdmin(AdminSearchBo adminSearchBo);

    void deletAdmins(Integer id);

    Integer getAdminId(AdminLoginBo adminLoginBo);

    void updateAdmin(AdminUpdateBo adminUpdateBo);

    AdminInfoVo getAdminById(int id);

    String getPwdByUsername(String adminToken);



    void changePwdByName(AdminChangePwdBo adminChangePwdBo);
}
