package com.example.creche.controllers;

import com.example.creche.modele.User;
import com.example.creche.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = " http://localhost:4200")


public class ControllerUser {
    private final   UserService userService;
    @Autowired

    public ControllerUser(UserService userService) {
        this.userService=userService;
    }
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return  userService.saveUser(user);
    }
    @GetMapping()
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }
    @DeleteMapping("/{id}")
    public  void  deleteUser (@PathVariable Long id){
        userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public  User updateUser(@PathVariable Long id, @RequestBody User userDetails){
        return  userService.updateUser(id, userDetails);
    }
}

