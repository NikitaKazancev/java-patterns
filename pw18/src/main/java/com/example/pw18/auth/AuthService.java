package com.example.pw18.auth;

import com.example.pw18.auth.Cookies.CookieEntity;
import com.example.pw18.auth.Cookies.CookieRepo;
import com.example.pw18.users.User;
import com.example.pw18.users.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final CookieRepo cookieRepo;

    public StatusCode login(AuthRequest body, HttpServletRequest request) {
        System.out.println(Arrays.toString(request.getCookies()));
        System.out.println(1);
        try {
            request.login(body.getName(), body.getPassword());

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails userDetails) {

                cookieRepo.save(CookieEntity.builder()
                       .userName(userDetails.getUsername())
                       .value("")
                       .build()
                );
            }
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return StatusCode.create(200);

//        Optional<User> res = userRepo.findByName(request.getName());
//        if (res.isPresent()) {
//            User user = res.get();
//            if (user.getPassword().equals(request.getPassword())) {
//                return AuthResult.builder().code(200).message("Login is success").build();
//            }
//        }
//
//
//
//        return AuthResult.builder().code(403).message("Unauthorized").build();
    }

    public StatusCode register(AuthRequest body) {
//        System.out.println(Arrays.toString(request.getCookies()));
        System.out.println(1);
        return StatusCode.create(200);
//        String encodedPassword = passwordEncoder.encode(authRequest.getPassword());
//
//        Optional<User> res = userRepo.findByName(authRequest.getName());
//        if (res.isPresent()) {
//            User user = res.get();
//            if (user.getPassword().equals(encodedPassword)) {
//                return AuthResult.builder().code(409).message("").build();
//            }
//        }
//
//        userRepo.save(
//                User.builder()
//                        .password(request.getPassword())
//                        .name(request.getName())
//                        .build()
//        );
//
//        return "register";
    }
}
