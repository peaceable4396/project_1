package com.cskaoyan.mall.dao;

import com.cskaoyan.mall.model.Admin;
import com.cskaoyan.mall.model.bo.*;
import com.cskaoyan.mall.model.vo.AdminInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    int queryCount(Admin admin);

    List<AdminInfoVo> selectAllAdmins();

    int insertAdmin(AdminAddBo adminAddBo);

    AdminInfoVo queryCountBYEmailorNickname(Admin admin);

    List<AdminInfoVo> searchAdmin(@Param("bo") AdminSearchBo adminSearchBo);

    void deletAdmin(int id);

    Integer getAdminId(AdminLoginBo adminLoginBo);

    void updateAdmin(AdminUpdateBo adminUpdateBo);

    AdminInfoVo getAdminById(int id);

    String getPwdByName(String adminToken);

    void changePwdByName(AdminChangePwdBo adminChangePwdBo);
}
