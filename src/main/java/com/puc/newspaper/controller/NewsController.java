package com.puc.newspaper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.newspaper.DTO.NewsRequest;
import com.puc.newspaper.domain.NewsDomain;
import com.puc.newspaper.model.News;

@RestController
@RequestMapping("/news")
@CrossOrigin(origins = "*")
public class NewsController {

  private NewsDomain newsDomain;

  public NewsController(NewsDomain newsDomain) {
    this.newsDomain = newsDomain;
  }

  @PostMapping("/create")
  public ResponseEntity<String> createNews(@RequestBody NewsRequest newsRequest) {

    try {

      String title = newsRequest.getTitle();
      String text = newsRequest.getText();
      newsDomain.saveNews(title, text);

      return ResponseEntity.ok().build();

    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }

  }

  @GetMapping("/get-all")
  public ResponseEntity<Iterable<com.puc.newspaper.model.News>> getAllNews() {

    try {

      Iterable<com.puc.newspaper.model.News> news = newsDomain.getAllNews();

      return ResponseEntity.ok(news);

    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }

  }

  @GetMapping("/get-by-id/{id}")
  public ResponseEntity<?> getById(@PathVariable Long id) {

    try {

      News news = newsDomain.getNewsById(id);

      return ResponseEntity.ok(news);

    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateNews(@PathVariable Long id, @RequestBody NewsRequest newsRequest) {

    try {

      String title = newsRequest.getTitle();
      String text = newsRequest.getText();
      News news = newsDomain.updateNews(id, title, text);

      return ResponseEntity.ok(news);

    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteNews(@PathVariable Long id) {

    try {

      newsDomain.deleteNews(id);

      return ResponseEntity.ok().build();

    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

}
