package com.kirana.auth.service;

import com.kirana.auth.entity.UserData;
import com.kirana.auth.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserData userData) {
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        userDataRepository.save(userData);
        return "User added";
    }

    public String generateToken(String username, String userId) {
        return jwtService.generateToken(username, userId);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
