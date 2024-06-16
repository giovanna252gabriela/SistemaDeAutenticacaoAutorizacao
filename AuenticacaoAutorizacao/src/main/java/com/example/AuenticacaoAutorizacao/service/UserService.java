package com.example.AuenticacaoAutorizacao.service;

import com.example.AuenticacaoAutorizacao.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String generateToken(String username) {
        String token = JwtUtil.generateToken(username);
        return token;
    }

    public String extractUsername(String token) {
        String username = JwtUtil.extractUsername(token);
        return username;
    }
}