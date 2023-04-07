package com.example.pw18.authentication.routes.components;

import com.example.pw18.authentication.cookies.CookieEntity;
import com.example.pw18.authentication.cookies.CookieRepo;
import com.example.pw18.authentication.jwt.JwtService;
import com.example.pw18.authentication.routes.dto.AuthRequestDTO;
import com.example.pw18.authentication.routes.dto.AuthResponseDTO;
import com.example.pw18.authentication.routes.dto.RegisterRequestDTO;
import com.example.pw18.users.User;
import com.example.pw18.users.UserRepo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final CookieRepo cookieRepo;

    public AuthResponseDTO register(RegisterRequestDTO requestData, HttpServletRequest request) {
        Optional<User> dbUser = userRepo.findByEmail(requestData.getEmail());
        if (dbUser.isPresent()) {
            return AuthResponseDTO.builder().jwt(null).status(409).build();
        }

        User user = User.builder()
                .name(requestData.getName())
                .email(requestData.getEmail())
                .password(passwordEncoder.encode(requestData.getPassword()))
                .build();

        userRepo.save(user);

        if (request != null) {
            for (Cookie cookie : request.getCookies()) {
                cookieRepo.save(CookieEntity.builder()
                        .value(cookie.getValue())
                        .build());
            }
        }

        return AuthResponseDTO.builder()
                .jwt(jwtService.createToken(user))
                .status(200)
                .build();
    }

    public AuthResponseDTO authenticate(AuthRequestDTO authData, HttpServletRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authData.getEmail(),
                        authData.getPassword()
                )
        );

        User user = userRepo.findByEmail(authData.getEmail())
                .orElseThrow();

        if (request != null) {
            for (Cookie cookie : request.getCookies()) {
                cookieRepo.save(CookieEntity.builder()
                        .value(cookie.getValue())
                        .build());
            }
        }

        return AuthResponseDTO.builder()
                .jwt(jwtService.createToken(user))
                .status(200)
                .build();
    }
}





