package com.wjy.mapper;

import com.wjy.domain.Activity;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/5 16:02
 * @Description:
 */
public interface ActivityMapper {


    List<Activity> queryActivity();

    int deleteActivity(Integer activityId);

    void insertActivity(Activity activity);

    Activity queryActivityById(Integer activityId);
}
