package com.example.pw18.admin;

import com.example.pw18.configuration.auth.JwtService;
import com.example.pw18.users.Role;
import com.example.pw18.users.User;
import com.example.pw18.users.UserRepo;
import com.example.pw18.users.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping
    public String admin(@NonNull HttpServletRequest request) {
        String jwt = request.getHeader("Authorization").substring(7);
        String email = jwtService.extractEmail(jwt);
        User user = userService.loadUserByUsername(email);
        if (user.getRole() == Role.ADMIN) {
            return "ADMIN";
        }
        return "USER";
    }
}
