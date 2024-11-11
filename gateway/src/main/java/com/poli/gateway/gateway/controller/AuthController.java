package com.poli.gateway.gateway.controller;


import com.poli.gateway.gateway.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider tokenProvider;

//    @GetMapping("/login/{username}")
//    public ResponseEntity<Map> authenticateUser(@RequestParam String username) {
//        if("guess".equals(username)){
//            String token = tokenProvider.generateToken(username);
//            Map<String, String> response = new HashMap<>();
//            response.put("token", token);
//            return ResponseEntity.ok(response);
//        }else {
//            throw new RuntimeException("Credenciales inválidas");
//        }
//
//    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
        if (authenticate(username, password)) {
            String token = tokenProvider.generateToken(username);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }

    private boolean authenticate(String username, String password) {
        // Ejemplo: validación de usuario y contraseña estática
        return "user".equals(username) && "password".equals(password);
    }
}

