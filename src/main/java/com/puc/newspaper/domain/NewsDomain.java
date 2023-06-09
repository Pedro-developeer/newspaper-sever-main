package com.puc.newspaper.domain;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.puc.newspaper.model.News;
import com.puc.newspaper.repo.NewsRepo;

@Service
public class NewsDomain {

  private NewsRepo newsRepo;

  public NewsDomain(NewsRepo newsRepo) {
    this.newsRepo = newsRepo;
  }

  public void saveNews(String title, String text) {

    Date date = new Date(System.currentTimeMillis());

    News news = new News(title, text, date);

    try {
      newsRepo.save(news);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Iterable<News> getAllNews() {
    return newsRepo.findAll();
  }

  public News getNewsById(Long id) {
    News news = newsRepo.findById(id).get();

    if (news == null) {
      throw new RuntimeException("News not found");
    }

    return news;

  }

  public News updateNews(Long id, String title, String text) {
    News news = newsRepo.findById(id).get();

    if (news == null) {
      throw new RuntimeException("News not found");
    }

    news.setTitle(title);
    news.setText(text);

    News updatedNews = newsRepo.save(news);

    return updatedNews;
  }

  public void deleteNews(Long id) {
    News news = newsRepo.findById(id).get();

    if (news == null) {
      throw new RuntimeException("News not found");
    }

    newsRepo.delete(news);
  }

}
