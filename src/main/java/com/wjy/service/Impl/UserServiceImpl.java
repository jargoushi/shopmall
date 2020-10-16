package com.wjy.service.Impl;

import com.wjy.domain.User;
import com.wjy.mapper.UserMapper;
import com.wjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 15:35
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryUser() {

        return userMapper.queryUser();
    }

    public boolean deleteUser(Integer userId) {

        return userMapper.deleteUser(userId) > 0;
    }

    public String queryUserName(User user) {

        User user1 = userMapper.queryUserName(user.getUserName());

        user.setUserId(user1.getUserId());

        if (user1 == null) {

            return "该用户未注册";
        }
        if (!user1.getPassWord().equals(user.getPassWord())) {

            return "密码错误";
        }

        return "OK";
    }

    public User queryUserById(Integer userId) {
        return userMapper.queryUserById(userId);
    }

    public boolean updateUser(String name, String email, String telephone) {
        return userMapper.updateUser(name, email, telephone) > 0;
    }

    public boolean updateUserPsw(Integer userId,String Psw) {
        return userMapper.updateUserPsw(userId,Psw) > 0;
    }
}
