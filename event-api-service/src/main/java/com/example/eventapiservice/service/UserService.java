package com.example.eventapiservice.service;

import com.example.eventapiservice.controller.util.Pagination;
import com.example.eventapiservice.entity.User;
import com.example.eventapiservice.payload.projection.UserCountProjection;
import com.example.eventapiservice.payload.projection.UserProjection;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUsernameIgnoreCase(String username);
    User findByUsername(String username);
    List<User> findByEmailContainingIgnoreCaseOrderByIdDesc(String email);
    User findUserById(Long id);
    UserCountProjection countUser();



    UserProjection findUserProjectById(Long id);
    UserProjection findUserProjectionByUsername(String username);
    List<UserProjection> findUserProjection(Pagination pagination);
    User addUser(User user);

}
