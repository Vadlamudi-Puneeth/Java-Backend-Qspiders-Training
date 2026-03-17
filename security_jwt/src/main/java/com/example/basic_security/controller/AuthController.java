package com.example.basic_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.basic_security.dto.*;
import com.example.basic_security.entity.User;
import com.example.basic_security.repository.UserRepository;
import com.example.basic_security.security.JwtUtil;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/auth/register")
    public User register(@RequestBody RegisterRequest request){

        User user=new User();

        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        return repo.save(user);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody AuthRequest request){

        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        return jwtUtil.generateToken(request.getUsername());
    }
    
    
    @GetMapping("/admin/data")
    public String adminData() {
        return "Admin data";
    }
    
    
    @GetMapping("/user/data")
    public String userData() {
        return "User data";
    }
    
    
    
}