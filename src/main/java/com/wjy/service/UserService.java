package com.wjy.service;

import com.wjy.domain.User;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 15:34
 * @Description:
 */
public interface UserService {

    List<User> queryUser();

    boolean deleteUser(Integer userId);

    String queryUserName(User user);

    User queryUserById(Integer userId);

    boolean updateUser(String name, String email, String telephone);

    boolean updateUserPsw(Integer userId,String newPsw);
}
