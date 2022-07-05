package com.cskaoyan.mall.dao;

import com.cskaoyan.mall.model.bo.UserSignupBo;
import com.cskaoyan.mall.model.po.User;

import java.util.List;

public interface UserDao {
    int addUser(UserSignupBo userSignupBo);

    List<User> getAllUser();

    List<User> searchUser(String name);

    void deletUserById(int id);

    User getUserByEmail(String email);

}
