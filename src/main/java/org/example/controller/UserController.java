package org.example.controller;

import org.example.abstraction.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public record UserController(
        UserService userService
) {

    @GetMapping("/getUser/{id}")
    public Mono<UserService.UserDto> findById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping("/addUser")
    public Mono<Long> addUser(@RequestBody UserService.AddUserDto addUserDto) {return userService.addUser(addUserDto);}
}
