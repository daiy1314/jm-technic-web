package com.jm.technic.controller;

import com.jm.technic.domain.User;
import com.jm.technic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取 User 列表
     * 处理 "/user" 的 GET 请求，用来获取 User 列表
     */
    @RequestMapping(value = "/userList")
    public String getBookList(ModelMap map) {
        List<User> users = userService.selectAll();
        map.addAttribute("userList", users);
        return "user/userList";
    }

    @RequestMapping(value = "/toCreateUser", method = RequestMethod.GET)
    public String toCreate(ModelMap map, @ModelAttribute("user") User user) {
        map.addAttribute("action", "createUser");
        return "user/userForm";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/userForm";
        }
        if (user != null) {
            user.setStatus(0);
            user.setCreateDate(new Date());
            user.setLastLoginDate(new Date());
            userService.insert(user);
        }
        return "redirect:/user/userList";
    }

    /**
     * 获取更新 User 表单
     * 处理 "/user/update/{id}" 的 GET 请求，通过 URL 中的 id 值获取 User 信息
     * URL 中的 id ，通过 @PathVariable 绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Integer id, ModelMap map) {
        User user = userService.selectByPrimaryKey(id);
        map.addAttribute("user", user);
        map.addAttribute("action", "update");
        return "user/userForm";
    }

    /**
     * 更新 User
     * 处理 "/update" 的 PUT 请求，用来更新 User 信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putUser(@ModelAttribute User user) {
        user.setLastLoginDate(new Date());
        userService.updateByPrimaryKey(user);
        return "redirect:/user/userList";
    }

    /**
     * 删除 User
     * 处理 "/user/{id}" 的 GET 请求，用来删除 User 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteByPrimaryKey(id);
        return "redirect:/user/userList";
    }
}
