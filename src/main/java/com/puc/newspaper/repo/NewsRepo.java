package com.puc.newspaper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puc.newspaper.model.News;

public interface NewsRepo extends JpaRepository<News, Long> {
  
}
