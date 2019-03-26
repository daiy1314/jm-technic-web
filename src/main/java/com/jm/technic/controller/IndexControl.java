package com.jm.technic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexControl {
    @RequestMapping("/index")
    public String index() {
        return "login/index";
    }

    @RequestMapping(value = "/")
    public String login() {
        int i = 100/0;
        return "login/login";
    }
}
