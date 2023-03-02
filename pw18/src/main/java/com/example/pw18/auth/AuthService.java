package com.example.pw18.auth;

import com.example.pw18.users.User;
import com.example.pw18.users.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;

    public AuthResult login(AuthRequest request) {
        Optional<User> res = userRepo.findByName(request.getName());
        if (res.isPresent()) {
            User user = res.get();
            if (user.getPassword().equals(request.getPassword())) {
                return AuthResult.builder().code(200).message("Login is success").build();
            }
        }

        return AuthResult.builder().code(403).message("Unauthorized").build();
    }

    public String register(AuthRequest request) {
        userRepo.save(
                User.builder()
                        .password(request.getPassword())
                        .name(request.getName())
                        .build()
        );

        return "register";
    }
}
