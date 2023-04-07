package com.example.pw18;

import com.example.pw18.authentication.jwt.JwtService;
import com.example.pw18.authentication.routes.components.AuthService;
import com.example.pw18.authentication.routes.dto.AuthRequestDTO;
import com.example.pw18.authentication.routes.dto.AuthResponseDTO;
import com.example.pw18.authentication.routes.dto.RegisterRequestDTO;
import com.example.pw18.users.User;
import com.example.pw18.users.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTests {
    @Mock
    private UserRepo userRepo;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authManager;
    @InjectMocks
    private AuthService authService;

    @Test
    void registerUser() {
        RegisterRequestDTO registerRequestDTO = RegisterRequestDTO.builder()
                .name("test-user-name")
                .lastname("test-user-lastname")
                .email("test-user-email")
                .password("test-user-password")
                .build();
        User dbUser = User.builder()
                .email("test-user-email")
                .password("pass")
                .build();

        Mockito.when(userRepo.findByEmail(registerRequestDTO.getEmail()))
                .thenReturn(Optional.ofNullable(dbUser));

        AuthResponseDTO registerRes = authService.register(registerRequestDTO, null);

        Assertions.assertEquals(409, registerRes.getStatus());
        Assertions.assertNull(registerRes.getJwt());
    }

    @Test
    void authenticateUser() {
        AuthRequestDTO authRequestDTO = AuthRequestDTO.builder()
                .email("test-user-email")
                .password("test-user-password")
                .build();
        User dbUser = User.builder()
                .email("test-user-email")
                .password("pass")
                .build();

        Mockito.when(userRepo.findByEmail(authRequestDTO.getEmail()))
                .thenReturn(Optional.ofNullable(dbUser));

        Mockito.when(authManager.authenticate(Mockito.any()))
                .thenReturn(null);

        Mockito.when(jwtService.createToken(dbUser))
                .thenReturn("token");

        AuthResponseDTO authRes = authService.authenticate(
                authRequestDTO,
                null
        );

        Assertions.assertEquals(200, authRes.getStatus());
        Assertions.assertEquals("token", authRes.getJwt());
    }
}
