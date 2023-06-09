package com.puc.newspaper.domain;

import com.puc.newspaper.utils.Encript;
import org.springframework.stereotype.Service;

import com.puc.newspaper.model.User;
import com.puc.newspaper.repo.UserRepo;

@Service
public class UserDomain {

  private UserRepo userRepo;

  public UserDomain(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public User save(String name, String email, String password, String plan, String typePlan) {

    String encriptedPassword = Encript.encodePassword(password);

    User user = new User(name, email, encriptedPassword, plan, typePlan);

    Boolean emailAlreadyExists = userRepo.existsByEmail(email);

    if (emailAlreadyExists) {
      throw new RuntimeException("Email already exists");
    }

    User createdUser = userRepo.save(user);

    return createdUser;
  }

  public User authenticate(String email, String password) {

    User user = userRepo.findByEmail(email);

    if (user == null) {
      throw new RuntimeException("User not found");
    }
    if (user != null && Encript.matchPassword(password, user.getPassword())) {
      return user;
    }
    else {
      throw new RuntimeException("User or password invalid");
    }


  }

  public User findById(Long id) {

    return userRepo.findById(id).get();

  }

}
