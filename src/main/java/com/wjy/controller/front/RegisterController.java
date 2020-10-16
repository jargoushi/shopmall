package com.wjy.controller.front;

import com.wjy.domain.User;
import com.wjy.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/10 15:57
 * @Description:
 */
@Controller
public class RegisterController {


    @Autowired
    private RegisterService registerService;

    @RequestMapping("/registerView")
    public String showRegisterView() {

        return "register";
    }

    @RequestMapping("/register")
    public ModelAndView showRegister(User user) {

        ModelAndView modelAndView = new ModelAndView();

        if (!user.getPassWord().equals(user.getConfirmPassword())) {

            modelAndView.addObject("errorMsg", "两次输入密码不一致");

            modelAndView.setViewName("register");

            return modelAndView;
        }
        String register = registerService.insertRegister(user);

        if("OK".equals(register)){

            modelAndView.setViewName("login");

            return modelAndView;
        }
        modelAndView.addObject("errorMsg", register);

        modelAndView.setViewName("register");

        return modelAndView;
    }
}
