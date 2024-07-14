package com.kirana.auth.service;

import com.kirana.auth.dto.CustomUserDetails;
import com.kirana.auth.entity.UserData;
import com.kirana.auth.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDataRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserData> userData = repository.findByName(username);
        return userData.map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with name:" + username));
    }
}
