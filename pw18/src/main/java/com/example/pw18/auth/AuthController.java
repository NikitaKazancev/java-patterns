package com.example.pw18.auth;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

//    @PostMapping("/login")
//    public ResponseEntity<StatusCode> login(
//            @RequestBody AuthRequest body,
//            @NonNull HttpServletRequest request
//    ) {
//        StatusCode response = service.login(body, request);
//        return ResponseEntity.status(response.getCode()).body(response);
//    }
//    @PostMapping("/register")
//    public ResponseEntity<StatusCode> register(
//            @RequestBody AuthRequest body
//    ) {
//        StatusCode response = service.register(body);
//        return ResponseEntity.status(response.getCode()).body(response);
//    }
}
