package com.puc.newspaper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.newspaper.DTO.UserRequest;
import com.puc.newspaper.domain.UserDomain;
import com.puc.newspaper.model.User;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
  
  private UserDomain userDomain;

  public UserController(UserDomain userDomain) {
    this.userDomain = userDomain;
  } 

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
    
    try {  

      User user = userDomain.save(userRequest.getName(), userRequest.getEmail(), userRequest.getPassword(), userRequest.getPlan(), userRequest.getTypePlan());
    
      return ResponseEntity.ok(user);

    } catch (Exception e) {
      
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }


  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody UserRequest userRequest) {
    
    try {  

      User user = userDomain.authenticate(userRequest.getEmail(), userRequest.getPassword());
    
      return ResponseEntity.ok(user);

    } catch (Exception e) {
      
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }


}
