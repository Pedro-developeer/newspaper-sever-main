package com.puc.newspaper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puc.newspaper.model.Sale;

public interface SaleRepo extends JpaRepository<Sale, Long> {
  
}