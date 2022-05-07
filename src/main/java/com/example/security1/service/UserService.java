package com.example.security1.service;

import com.example.security1.model.User;
import com.example.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User joinUser(String username, String password, String email) {
        String encodedPwd = encodePassword(password);
        User newUser = new User(username, encodedPwd, email, "ROLE_USER");
        return userRepository.save(newUser);
    }

    private String encodePassword(String originPwd) {
        return bCryptPasswordEncoder.encode(originPwd);
    }
}
