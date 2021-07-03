package com.example.eventapiservice.controller;

import com.example.eventapiservice.controller.util.ApiResponse;
import com.example.eventapiservice.controller.util.ApiStatus;
import com.example.eventapiservice.controller.util.Pagination;
import com.example.eventapiservice.entity.Role;
import com.example.eventapiservice.entity.User;
import com.example.eventapiservice.payload.AddUserRequest;
import com.example.eventapiservice.payload.projection.UserProjection;
import com.example.eventapiservice.service.RoleService;
import com.example.eventapiservice.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController  //  @Controller + @ResponseBody
//@Hidden
@RequestMapping("/api/v1/user-mgt/user")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService,
                          RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    //@RequestMapping(method = RequestMethod.GET)
    @Parameters({
            @Parameter(
                    in = ParameterIn.QUERY,
                    description = "Page you want to retrieve (0...N)",
                    name = "page",
                    content = @Content(schema = @Schema(type = "integer" , defaultValue = "0"))
            ),
            @Parameter(
                    in = ParameterIn.QUERY,
                    description = "Number of records per page.",
                    name = "size",
                    content = @Content(schema = @Schema(type = "integer" , defaultValue = "20"))
            )
    })
    @GetMapping
    //@Hidden
    public ApiResponse<List<UserProjection>> findAll(@Parameter(hidden = true) Pagination pagination){
        List<UserProjection> userProjections = userService.findUserProjection(pagination);
        return new ApiResponse<>(
                ApiStatus.SUC_RETRIEVED.getCode(),
                ApiStatus.SUC_RETRIEVED.getMessage(),
                userProjections,
                pagination
        );
    }

    @GetMapping("/{user-id}")
    public ApiResponse<UserProjection> findById(@PathVariable("user-id") Long id){
        UserProjection userProjection = userService.findUserProjectById(id);
        if(userProjection == null){
            return new ApiResponse<>(ApiStatus.NOT_FOUND.getCode(), ApiStatus.NOT_FOUND.getMessage());
        }
        return new ApiResponse<>(
                ApiStatus.SUC_RETRIEVED.getCode(),
                ApiStatus.SUC_RETRIEVED.getMessage(),
                userProjection
        );
    }

    @PostMapping  //  =  @RequestMapping(method = RequestMethod.POST)
    public ApiResponse registerUser(@RequestBody AddUserRequest addUserRequest){

        User user = new User();

        user.setUsername(addUserRequest.getUsername());
        user.setEmail(addUserRequest.getEmail());
        user.setGender(addUserRequest.getGender());
        user.setPassword(addUserRequest.getPassword());

        // TODO: Add Role if exist
        List<Role> roles = new ArrayList<>();
        for(Long roleId : addUserRequest.getRoleId()){
            Role role = roleService.findById(roleId);
            roles.add(role);
        }
        user.setRoles(roles);
        User userAdded = userService.addUser(user);

        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                userAdded
        );
    }

    @PutMapping // =  @RequestMapping(method = RequestMethod.PUT)
    public ApiResponse updateUser(/* UpdateUserRequest updateUserRequest */){

        // implement code update


        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage()
        );
    }

    @DeleteMapping("/{id}") // =  @RequestMapping(method = RequestMethod.DELETE)
    public ApiResponse deleteById(@PathVariable Long id){

        // implement code delete


        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage()
        );
    }




}
