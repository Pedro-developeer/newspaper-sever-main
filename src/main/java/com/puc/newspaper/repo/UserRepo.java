package com.puc.newspaper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puc.newspaper.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
  
  Boolean existsByEmail(String email);
  User findByEmail(String email);
  
}
