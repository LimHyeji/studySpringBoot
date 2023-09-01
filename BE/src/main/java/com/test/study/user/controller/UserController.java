package com.test.study.user.controller;

import com.test.study.user.model.dto.request.UserRegistRequestDTO;
import com.test.study.user.model.dto.response.UserRegistResponseDTO;
import com.test.study.user.model.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private ResponseEntity<UserRegistResponseDTO> regist(final @Valid UserRegistRequestDTO userRegistRequestDTO){
        return ResponseEntity.ok().body(userService.regist(userRegistRequestDTO));
    }
}
