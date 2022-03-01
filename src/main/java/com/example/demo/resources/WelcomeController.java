package com.example.demo.resources;


import com.example.demo.config.AuthRequest;
import com.example.demo.domain.Staff;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class WelcomeController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/")
    public String welcome(){
        return "Welcome to my app";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<HashMap<String, String>> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                            authRequest.getPassword())
            );
        } catch (Exception e){
            throw new Exception("invalid username//passowrd");
        }

        HashMap<String, String> result = new HashMap<>();
        result.put("Token", jwtUtil.generateToken(authRequest.getUsername()));

        return ResponseEntity.ok().body(result);


    }
}
