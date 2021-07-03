package com.example.eventui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryPageController {
    @RequestMapping({ "","/", "/list"})
    public String categoryList(){
        return "category/category-list";
    }

    @RequestMapping( "/add")
    public String addCategory(){
        return "category/category-add";
    }
}
