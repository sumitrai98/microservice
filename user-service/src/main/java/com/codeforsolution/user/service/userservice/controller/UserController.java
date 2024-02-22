package com.codeforsolution.user.service.userservice.controller;

import com.codeforsolution.user.service.userservice.config.AuthConfig;
import com.codeforsolution.user.service.userservice.model.User;
import com.codeforsolution.user.service.userservice.model.UserRequest;
import com.codeforsolution.user.service.userservice.repository.UserRepository;
import com.codeforsolution.user.service.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save-user")
    public ResponseEntity<User> saveUsers(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
    @PostMapping("/token")
    public String getToken(@RequestBody UserRequest user){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authenticate.isAuthenticated()) {
            return userService.generateToken(user.getUsername());
        }else {
            throw new RuntimeException("Invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
         userService.validateToken(token);
         return "valid token";
    }

}
