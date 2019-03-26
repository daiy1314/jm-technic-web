package com.jm.technic.controller;

import com.jm.technic.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping("")
    public String showInfo(Model model) {
        List<User> list  = new ArrayList<>();
        return "";
    }
}
