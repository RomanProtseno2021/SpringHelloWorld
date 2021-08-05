package com.example.springhelloworld.controllers;

import com.example.springhelloworld.services.UsersService;
import com.example.springhelloworld.stucts.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Setter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "UsersController", description = "Контролер для роботи з користувачами")
public class UsersController {

    @Setter
    @Autowired
    private UsersService usersService;

    @GetMapping("/get-users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = usersService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @ApiOperation(
            value = "отримати користувачів по id",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-user-by-id")
    public ResponseEntity<User> getUserById(
            @ApiParam(value = "id користувача", required = false)
            @RequestParam(value = "user-id", required = false)
                    Integer userId) {
        return ResponseEntity.ok().body(usersService.getUserById(userId));
    }

    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(
            @RequestBody User user) {
        return ResponseEntity.ok().body(usersService.addUser(user));
    }

    @PatchMapping("/update-user")
    public ResponseEntity<User> updateUser(@ApiParam(value = "id користувача", required = true)
                                           @RequestParam(value = "user-id") Integer userId,
                                           @RequestBody User user) {
        return ResponseEntity.ok().body(usersService.updateUser(userId, user));
    }

    @DeleteMapping("/delete-user-by-id")
    public ResponseEntity<Boolean> deleteUserById(@ApiParam(value = "id користувача", required = true)
                               @RequestParam(value = "user-id")
                                       Integer id) {
        return ResponseEntity.ok().body(usersService.deleteUserById(id));
    }
}
