package com.example.pw18.authentication.routes.components;

import com.example.pw18.authentication.routes.dto.AuthRequestDTO;
import com.example.pw18.authentication.routes.dto.AuthResponseDTO;
import com.example.pw18.authentication.routes.dto.RegisterRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(
            @RequestBody RegisterRequestDTO registerData,
            HttpServletRequest request
    ) {
        AuthResponseDTO response = authService.register(registerData, request);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(
            @RequestBody AuthRequestDTO authData,
            HttpServletRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(authData, request));
    }
}
