package com.chalkup.ChalkUp.controller;

import com.chalkup.ChalkUp.model.User;
import com.chalkup.ChalkUp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public User createTask(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Long id){
        return userService.deleteuser(id);
    }
}
