package com.puc.newspaper.domain;

import com.puc.newspaper.utils.Encript;
import org.springframework.stereotype.Service;

import com.puc.newspaper.model.Admin;
import com.puc.newspaper.repo.AdminRepo;

@Service
public class AdminDomain {

  private AdminRepo adminRepo;

  public AdminDomain(AdminRepo adminRepo) {
    this.adminRepo = adminRepo;
  }

  public Admin save(String name, String email, String password) {

    String encriptedPassword = Encript.encodePassword(password);

    Admin admin = new Admin(name, email, encriptedPassword);

    Boolean emailAlreadyExists = adminRepo.existsByEmail(email);

    if (emailAlreadyExists) {
      throw new RuntimeException("Email already exists");
    }

    Admin createdAdmin = adminRepo.save(admin);

    return createdAdmin;

  }

  public Admin authenticate(String email, String password) {
    
    Admin admin = adminRepo.findByEmail(email);

    if (admin == null) {
      throw new RuntimeException("Admin not found");
    }

    if (admin != null && Encript.matchPassword(password, admin.getPassword())) {
      return admin;
    }

    else {
      throw new RuntimeException("User or password invalid");
    }


  }

}
