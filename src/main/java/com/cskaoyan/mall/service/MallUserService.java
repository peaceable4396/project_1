package com.cskaoyan.mall.service;

import com.cskaoyan.mall.model.bo.UserSignupBo;
import com.cskaoyan.mall.model.bo.UserUpdateBo;
import com.cskaoyan.mall.model.po.User;

public interface MallUserService {
    int addUser(UserSignupBo userSignupBo);

    String getUserByName(String email);

    User getUserByEmail(String email);

    String getPwdByuserId(Integer userId);

    void changePwdByUserId(Integer userId, String newPwd);

    void updateUser(UserUpdateBo userUpdateBo);

}
