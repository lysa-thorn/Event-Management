package com.example.eventapiservice.controller;

import com.example.eventapiservice.controller.util.ApiResponse;
import com.example.eventapiservice.controller.util.ApiStatus;
import com.example.eventapiservice.entity.Role;
import com.example.eventapiservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-mgt/role")
public class RoleController {

    public RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping
    public ApiResponse<List<Role>> findAll(){
        return new ApiResponse<>(
                ApiStatus.SUC_RETRIEVED.getCode(),
                ApiStatus.SUC_RETRIEVED.getMessage(),
                roleService.findAll()
                );
    }

}
