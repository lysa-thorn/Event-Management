package com.example.eventapiservice.service;

import com.example.eventapiservice.entity.Category;

import java.util.List;

public interface CategoryService {

    Category addCategory(String roleName);
    List<Category> findAll();
    Category findById(Long id);

}
