package com.wjy.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjy.domain.ResponseResult;
import com.wjy.domain.User;
import com.wjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 17:05
 * @Description:
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showjson")
    @ResponseBody
    public ResponseResult showUser(@RequestParam(value = "page", defaultValue = "1") Integer page) {

        PageHelper.startPage(page,5);

        List<User> users = userService.queryUser();

        PageInfo pageInfo = new PageInfo(users);

        Map<String, Object> info = new HashMap<String, Object>();

        info.put("pageInfo", pageInfo);

        return ResponseResult.success(info);

    }

    @RequestMapping("/delete/{userId}")
    @ResponseBody
    public ResponseResult delteUser(@PathVariable Integer userId) {

        boolean flag = userService.deleteUser(userId);

        if (flag) {
            ResponseResult success = ResponseResult.success(null);

            success.setMsg("刪除用戶成功");
            return success;
        }
        return ResponseResult.fail("刪除用戶失敗");
    }
}
