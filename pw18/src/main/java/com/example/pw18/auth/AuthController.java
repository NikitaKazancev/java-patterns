package com.example.pw18.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
//        AuthResult result = service.login(request);
//        return ResponseEntity.status(result.getCode()).body(result.getMessage());
//    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
//
////        return ResponseEntity.ok(service.register(request));
//    }
}
