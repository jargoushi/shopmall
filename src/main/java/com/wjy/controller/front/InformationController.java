package com.wjy.controller.front;

import com.wjy.domain.Goods;
import com.wjy.domain.ResponseResult;
import com.wjy.domain.User;
import com.wjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/11 15:10
 * @Description:
 */
@Controller
public class InformationController {


    @Autowired
    private UserService userService;


    @RequestMapping("/information")
    public ModelAndView showInformation(HttpSession session) {

        User user =(User)session.getAttribute("user");

        ModelAndView modelAndView = new ModelAndView();

        if (user == null) {

            modelAndView.setViewName("/login");

            return modelAndView;
        }

        User user1 = userService.queryUserById(user.getUserId());

        modelAndView.addObject("user", user1);

        modelAndView.setViewName("information");

        return modelAndView;
    }

    @RequestMapping("/saveInfo")
    @ResponseBody
    public ResponseResult showSaveInfo(String email,String telephone,HttpSession session) {

        User user =(User) session.getAttribute("user");

        if (user == null) {

            return ResponseResult.fail("更新失败");
        }
        User user1 = userService.queryUserById(user.getUserId());

        boolean flag = userService.updateUser(user1.getUserName(), email, telephone);

        if (flag) {

            return ResponseResult.success("修改成功", null);
        }

        return ResponseResult.fail("更新失败");
    }

    @RequestMapping("/savePsw")
    @ResponseBody
    public ResponseResult showSavePsw(String Psw,HttpSession session) {

        User user =(User) session.getAttribute("user");

        if (user == null) {

            return ResponseResult.fail("更新失败");
        }
        boolean flag = userService.updateUserPsw(user.getUserId(),Psw);

        if (flag) {

            return ResponseResult.success("修改成功", null);
        }

        return ResponseResult.fail("更新失败");
    }

}

