package com.example.pw18.authentication.routes.components;

import com.example.pw18.users.User;
import com.example.pw18.users.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email)
                .orElse(null);
    }
}
