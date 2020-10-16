package com.wjy.service.Impl;

import com.wjy.domain.Activity;
import com.wjy.mapper.ActivityMapper;
import com.wjy.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/5 16:01
 * @Description:
 */
@Service
public class ActivityServiceImpl implements ActivityService {


    @Autowired
    private ActivityMapper activityMapper;

    public List<Activity> queryActivity() {
        return activityMapper.queryActivity();
    }

    public boolean deleteActivity(Integer activityId) {
        return activityMapper.deleteActivity(activityId) > 0;
    }

    public void insertActivity(Activity activity) {

        activityMapper.insertActivity(activity);
    }

    public Activity queryActivityById(Integer activityId) {
        return activityMapper.queryActivityById(activityId);
    }
}
