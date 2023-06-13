package com.example.demo2.controller;

import com.example.demo2.entity.Login;
import com.example.demo2.entity.MyResponse;
import com.example.demo2.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    JwtProvider provider;
    @Autowired
    MyResponse response = new MyResponse();
    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails userDetails= (UserDetails)authentication.getPrincipal();
        securityContext.setAuthentication(authentication);
        String token = provider.createToken(authentication);
        response.data = userDetails;
        response.msg = "success";
        response.status = 200;
        response.token = token;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
