package com.example.mainwebappspringboot.controller;


import com.example.mainwebappspringboot.entity.Users;
import com.example.mainwebappspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model, HttpServletResponse response) {
        return "Hello spring boot index";
    }

    @GetMapping("/users")
    public List<Users> showAllUsers() {
        List<Users> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable int id) {
        Users user = userService.getUser(id);
        return user;
    }

    @PostMapping("/users")
    public Users addNewUser(@RequestBody Users user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public Users updateUser(@RequestBody Users user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User with ID = " + id + "was deleted";
    }

}
