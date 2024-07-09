package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable long id){
        return userService.findById(id);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        return userService.delete(id);
    }
//    @PutMapping
//    public User update(@RequestBody User user){
//        return userService.update(user);
//    }
}
