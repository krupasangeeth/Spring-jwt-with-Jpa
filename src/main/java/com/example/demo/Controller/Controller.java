package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtService;
import com.example.demo.entity.AuthRequest;

@RestController
public class Controller {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;
    
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
    public String authenticateAndGenerateToken(@RequestBody AuthRequest authRequest){
        // Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        // if(authentication.isAuthenticated())
        //     return jwtService.generateToken(authRequest.getUsername());
        // else   
        //     throw new UsernameNotFoundException("Invalid Details");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }


}
