package com.wjy.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wjy.domain.Activity;
import com.wjy.service.ActivityService;
import com.wjy.service.CategoryService;
import com.wjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 16:13
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ActivityService activityService;


    @RequestMapping("/index")
    public String showAdminView(){

        return "admin";
    }

    @RequestMapping("/user/show")
    public String showUserView(){

        return "userManage";
    }

    @RequestMapping("/goods/show")
    public ModelAndView showGoodsView(){

        // categoryList
        ModelAndView view = new ModelAndView();
        view.setViewName("adminAllGoods");

        view.addObject("categoryList", categoryService.queryCategory());
        return view;
    }

    @RequestMapping("/activity/show")
    public ModelAndView showactivityView(){

        ModelAndView view = new ModelAndView();

        List<Activity> activities = activityService.queryActivity();

        PageInfo pageInfo = new PageInfo(activities);

        view.addObject("pageInfo", pageInfo);

        view.setViewName("activity");

        return view;
    }

    @RequestMapping("/logout")
    public String showLogoutView(HttpSession session){

        session.removeAttribute("user");

        return "redirect:/main";
    }


}
