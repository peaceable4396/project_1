package com.cskaoyan.mall.dao;

import com.cskaoyan.mall.model.bo.UserSignupBo;
import com.cskaoyan.mall.model.bo.UserUpdateBo;
import com.cskaoyan.mall.model.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallUserDao {
    String getUserByName(String email);

    List<String> getAllUserEmails();

    void addUser(UserSignupBo userSignupBo);

    User getUserByEmail(String email);

    String getPwdByuserId(Integer userId);

    void changePwdByUserId(@Param("userId") Integer userId, @Param("newPwd") String newPwd);

    void updateUser(UserUpdateBo userUpdateBo);

}
