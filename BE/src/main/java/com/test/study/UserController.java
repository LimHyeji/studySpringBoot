package com.test.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/regist")
    private ResponseEntity<User> regist(@RequestBody User user){
        return ResponseEntity.ok(userService.regist(user));
    }

    @PostMapping("/login")
    private ResponseEntity<User> login(@RequestBody User user){
        return ResponseEntity.ok(userService.login(user));
    }
}
