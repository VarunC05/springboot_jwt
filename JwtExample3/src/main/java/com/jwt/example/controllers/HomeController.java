package com.jwt.example.controllers;

import com.jwt.example.models.Emp;
import com.jwt.example.models.User;
import com.jwt.example.repo.EmpRepo;
import com.jwt.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    EmpRepo empRepo;

    @GetMapping("/user")
    public List<User> getUser(){
        return userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
    return principal.getName();

    }

    @GetMapping("/getUserFromDb")
    public List<Emp> getUserFromDb(){
        return empRepo.findAll();
    }
}
