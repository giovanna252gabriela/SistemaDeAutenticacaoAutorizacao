package com.example.AuenticacaoAutorizacao.controller;

import com.example.AuenticacaoAutorizacao.model.UserEntity;
import com.example.AuenticacaoAutorizacao.service.UserService;
import com.example.AuenticacaoAutorizacao.model.UserEntity;
import com.example.AuenticacaoAutorizacao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserEntity request) {
        // Adicione lógica para verificar credenciais
        if ("giovanna".equals(request.getUsername()) && "0311".equals(request.getPassword())) {
            String token = userService.generateToken(request.getUsername());
            return token;
        }
        return "Invalid credentials";
    }

    @GetMapping("/username/{token}")
    public String extractUsername(@PathVariable String token) {
        String username = userService.extractUsername(token);
        return username;
    }

    @GetMapping("/user")
    public String getUser(Authentication authentication) {
        return "user: " + authentication.getName();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String onlyAdmin(Authentication authentication) {
        return "admin: " + authentication.getName();
    }

    @Secured("ROLE_MODERADO")
    @GetMapping("/moderado")
    public String onlyModerado(Authentication authentication) {
        return "moderado: " + authentication.getName();
    }

    @Secured("ROLE_COMUM")
    @GetMapping("/comum")
    public String onlyComum(Authentication authentication) {
        return "Comum: " + authentication.getName();
    }
}
