package org.example.controller;

import org.example.abstraction.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public record UserController(
        UserService userService
) {

    @GetMapping("/getUser/{id}")
    public Mono<UserService.UserDto> findById(@PathVariable Long id){
        return userService.getById(id);
    }
}
