package com.wjy.service.Impl;

import com.wjy.domain.User;
import com.wjy.mapper.RegisterMapper;
import com.wjy.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/10 16:10
 * @Description:
 */
@Service
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    private RegisterMapper registerMapper;


    public String insertRegister(User user) {

        user.setRegTime(new Date());

        User user1 = registerMapper.queryUser(user);

        if (user1 != null) {
            return "该用户已注册";
        }

        int i =  registerMapper.insertUser(user);

        if(i > 0){
            return "OK";
        }
        return "注册失败";
    }
}
