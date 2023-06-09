package com.puc.newspaper.DTO;

public class NewsRequest {

  private String title;
  private String text;

  public NewsRequest() {
  }

  public NewsRequest(String title, String text) {
    this.title = title;
    this.text = text;
  }

  /**
   * @return String return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return String return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
  }

}
