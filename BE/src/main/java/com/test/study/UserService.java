package com.test.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User regist(User user) {
        userRepository.save(user);
        return userRepository.findById(user.getUserId()).orElseThrow();
    }

    public User login(User user) {
        User returnUser=userRepository.findById(user.getUserId()).orElseThrow();
        if(returnUser.getUserPw().equals(user.getUserPw())){
            return user;
        }
        return null;
    }
}
