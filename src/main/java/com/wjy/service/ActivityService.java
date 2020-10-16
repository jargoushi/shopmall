package com.wjy.service;

import com.wjy.domain.Activity;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/5 16:00
 * @Description:
 */
public interface ActivityService {

    List<Activity> queryActivity();

    boolean deleteActivity(Integer activityId);

    void insertActivity(Activity activity);

    Activity queryActivityById(Integer activityId);
}
