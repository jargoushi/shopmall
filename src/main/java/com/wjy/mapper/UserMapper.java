package com.wjy.mapper;

import com.wjy.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 15:36
 * @Description:
 */
public interface UserMapper {

    List<User> queryUser();

    int deleteUser(Integer userId);

    User queryUserName(String userName);

    User queryUserById(Integer userId);

    int updateUser(@Param("name") String name,@Param("email") String email,@Param("telephone") String telephone);

    int updateUserPsw(@Param("userId") Integer userId,@Param("Psw") String Psw);
}
