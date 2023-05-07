package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtService;
import com.example.demo.entity.AuthRequest;

@RestController
public class Controller {

    @Autowired
    JwtService jwtService;
    
    @GetMapping("/loggedin/")
    public String welcome(){
        return "<H1>Welcome</H1>";
    }

    @GetMapping("/loggedin/user")
    public String userMethod(){
        return "<H1>Welcome User</H1>";
    }

    @GetMapping("/loggedin/admin")
    public String adminMethod(){
        return "<H1>Welcome Admin</H1>";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGenerateToken(AuthRequest authRequest){
        return jwtService.generateToken(authRequest.getUsername());
    }


}
