package com.wjy.mapper;

import com.wjy.domain.User; /**
 * @Auther: ruwenbo
 * @Date: 2020/8/10 16:11
 * @Description:
 */
public interface RegisterMapper {


    User queryUser(User user);

    int insertUser(User user);

}
