package com.example.eventui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserPageController {

    @RequestMapping({ "","/", "/list"})
    public String userList(){
        return "user/user-list";
    }

    @RequestMapping({"/add"})
    public String userAdd(){
        return "user/user-add";
    }

}
