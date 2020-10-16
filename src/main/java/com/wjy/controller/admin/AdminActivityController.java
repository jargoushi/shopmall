package com.wjy.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wjy.domain.Activity;
import com.wjy.domain.ResponseResult;
import com.wjy.service.ActivityService;
import com.wjy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/5 15:15
 * @Description:
 */
@Controller
@RequestMapping("/admin/activity")
public class AdminActivityController {


    @Autowired
    private ActivityService activityService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/showjson")
    @ResponseBody
    public ResponseResult showActivity(){


        List<Activity> activity = activityService.queryActivity();


        Map<String, Object> info = new HashMap<String, Object>();

        info.put("activity", activity);

        return ResponseResult.success(info);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public ResponseResult showUpdate(Integer activityId,Integer goodsId) {

        boolean flag = goodsService.updateActivityId(activityId, goodsId);

        if(flag){
            return ResponseResult.success("修改活动信息成功", null);
        }
        return ResponseResult.fail("修改活动信息失败");
    }

    @RequestMapping("/add")
    public String showAdd() {

        return "addActivity";
    }

    @RequestMapping("/delete")
    public ModelAndView showDelete(Integer activityId) {

        activityService.deleteActivity(activityId);
        ModelAndView view = new ModelAndView();

        List<Activity> activities = activityService.queryActivity();

        PageInfo pageInfo = new PageInfo(activities);

        view.addObject("pageInfo", pageInfo);

        view.setViewName("activity");
        return view;
    }


    @RequestMapping("/addResult")
    public String showAddResult(Activity activity) {

        activityService.insertActivity(activity);

        return "redirect:/admin/activity/show";
    }
}
