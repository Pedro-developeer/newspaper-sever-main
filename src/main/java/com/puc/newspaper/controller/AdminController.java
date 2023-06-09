package com.puc.newspaper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.newspaper.DTO.AdminRequest;
import com.puc.newspaper.domain.AdminDomain;
import com.puc.newspaper.model.Admin;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
  
  private AdminDomain adminDomain;

  public AdminController(AdminDomain adminDomain) {
    this.adminDomain = adminDomain;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody AdminRequest adminRequest) {
    
    try {  

      Admin Admin = adminDomain.save(adminRequest.getName(), adminRequest.getEmail(), adminRequest.getPassword());
    
      return ResponseEntity.ok(Admin);

    } catch (Exception e) {
      
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AdminRequest adminRequest) {
    
    try {  

      Admin admin = adminDomain.authenticate(adminRequest.getEmail(), adminRequest.getPassword());
    
      return ResponseEntity.ok(admin);

    } catch (Exception e) {
      
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

}
