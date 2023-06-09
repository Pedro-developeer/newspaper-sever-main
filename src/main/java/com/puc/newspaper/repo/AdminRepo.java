package com.puc.newspaper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puc.newspaper.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {
  
  Boolean existsByEmail(String email);
  Admin findByEmail(String email);

}
