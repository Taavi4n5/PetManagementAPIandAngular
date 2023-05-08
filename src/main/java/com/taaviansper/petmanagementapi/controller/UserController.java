package com.taaviansper.petmanagementapi.controller;


import com.taaviansper.petmanagementapi.DTO.AuthRequest;
import com.taaviansper.petmanagementapi.DTO.ResponseDTO;
import com.taaviansper.petmanagementapi.model.UserModel;
import com.taaviansper.petmanagementapi.service.JwtService;
import com.taaviansper.petmanagementapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameNotFoundException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200") // This is to allow the Angular app to access the API
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService us;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody AuthRequest authRequest) {
        Optional<UserModel> optionalUser = us.findUserByName(authRequest.getName());

        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            if (encoder.matches(authRequest.getPassword(), user.getPassword())) {
                ResponseDTO response = new ResponseDTO(200,"success", "Login successful");
                return ResponseEntity.ok(response);
            } else {
                ResponseDTO response = new ResponseDTO(403,"error", "Invalid password");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } else {
            ResponseDTO response = new ResponseDTO(404,"error", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<ResponseDTO> authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws NameNotFoundException {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                String token = jwtService.generateToken(authRequest.getName());
                ResponseDTO response = new ResponseDTO(200, "success", token);
                return ResponseEntity.ok(response);
            } else {
                throw new NameNotFoundException("Invalid request");
            }
        } catch (AuthenticationException ex) {
            ResponseDTO response = new ResponseDTO(401, "failed", "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}