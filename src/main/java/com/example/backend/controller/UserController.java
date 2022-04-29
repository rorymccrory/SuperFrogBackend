package com.example.backend.controller;

import com.example.backend.domain.Result;
import com.example.backend.domain.StatusCode;
import com.example.backend.domain.User;
import com.example.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @CrossOrigin
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "Find All Success", service.findAll());
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", service.findById(id));
    }
    @CrossOrigin
    @PostMapping
    public Result save(@RequestBody User user) {
        service.save(user);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public Result update(@RequestBody User user, @PathVariable Integer id) {
        service.update(id, user);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        service.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}

