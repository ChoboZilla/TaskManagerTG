package org.example.server.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.example.server.abstraction.service.UserService;
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

    @PostMapping("/signUp")
    public Mono<Long> signUp(@RequestBody UserService.AddUserDto addUserDto) {return userService.addUser(addUserDto);}

    @PostMapping("/signIn")
    public Mono<UserService.UserDto> signIn(@RequestBody UserService.SignInDto signInDto, HttpServletResponse response) {
        return userService.signIn(signInDto)
                .doOnNext(user -> {
                    var cookie = new Cookie("userId", String.valueOf(user.id()));
                    cookie.setMaxAge(3600);
                    cookie.setPath("/");
                    response.addCookie(cookie );
                });
    }
}
