package com.puc.newspaper.DTO;

public class SaleRequest {

  private Long userId;
  private String plan;
  private String typePlan;
  private Integer price;

  public SaleRequest() {
  }

  public SaleRequest(Long userId, String plan, String typePlan, Integer price) {
    this.userId = userId;
    this.plan = plan;
    this.typePlan = typePlan;
    this.price = price;
  }

  /**
   * @return Long return the userId
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  /**
   * @return String return the plan
   */
  public String getPlan() {
    return plan;
  }

  /**
   * @param plan the plan to set
   */
  public void setPlan(String plan) {
    this.plan = plan;
  }

  /**
   * @return String return the typePlan
   */
  public String getTypePlan() {
    return typePlan;
  }

  /**
   * @param typePlan the typePlan to set
   */
  public void setTypePlan(String typePlan) {
    this.typePlan = typePlan;
  }

  /**
   * @return Integer return the price
   */
  public Integer getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(Integer price) {
    this.price = price;
  }

}
