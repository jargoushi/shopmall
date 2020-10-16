package com.wjy.controller.front;

import com.wjy.domain.User;
import com.wjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/10 15:55
 * @Description:
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String showLogin() {

        return "login";
    }

    @RequestMapping("/loginConfirm")
    public ModelAndView showLoginConfirm(String userName, String passWord, String verifyCode, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();

        String certCode = (String) session.getAttribute("certCode");

        if (!certCode.equals(verifyCode)) {

            modelAndView.addObject("errorMsg", "验证码输入错误");

            modelAndView.setViewName("login");

            return modelAndView;
        }

        User user = new User();

        user.setUserName(userName);

        user.setPassWord(passWord);

        String login = userService.queryUserName(user);

        if ("OK".equals(login)) {

            session.setAttribute("user", user);

            modelAndView.setViewName("redirect:/main");

            return modelAndView;
        }
        modelAndView.addObject("errorMsg", login);

        modelAndView.setViewName("login");

        return modelAndView;
    }

    @RequestMapping("/logout")
    public String showLogoutView(HttpSession session){

        session.removeAttribute("user");

        return "redirect:/main";
    }
}
