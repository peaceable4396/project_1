package com.cskaoyan.mall.service;

import com.cskaoyan.mall.model.po.User;

import java.util.List;

/**
 * @projectName: project_1
 * @package: com.cskaoyan.mall.service
 * @className: UserService
 * @author: sx
 * @description: TODO
 * @date: 2022/6/29 9:48
 * @version: 1.0
 */
public interface UserService {

    List<User> getAllUser();

    List<User> searchUser(String word);

    void deletUserById(int id);

    User getUserByEmail(String token);
}
