package com.test.study.user.model.service;

import com.test.study.user.model.dto.request.UserRegistRequestDTO;
import com.test.study.user.model.dto.response.UserRegistResponseDTO;
import com.test.study.user.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegistResponseDTO regist(UserRegistRequestDTO userRegistRequestDTO) {
        return new UserRegistResponseDTO();
    }
}
