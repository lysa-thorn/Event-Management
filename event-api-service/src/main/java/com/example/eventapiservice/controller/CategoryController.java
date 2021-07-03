package com.example.eventapiservice.controller;

import com.example.eventapiservice.controller.util.ApiResponse;
import com.example.eventapiservice.controller.util.ApiStatus;
import com.example.eventapiservice.entity.Category;
import com.example.eventapiservice.entity.Role;
import com.example.eventapiservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-mgt/category")
public class CategoryController {

    public CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ApiResponse<List<Category>> findAll(){
        return new ApiResponse<>(
                ApiStatus.SUC_RETRIEVED.getCode(),
                ApiStatus.SUC_RETRIEVED.getMessage(),
                categoryService.findAll()
                );
    }

}
