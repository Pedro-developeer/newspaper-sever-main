package com.puc.newspaper.DTO;

public class SaleReport {

  private String clientName;
  private String email;
  private String plan;
  private String typePlan;
  private double amount;

  /**
   * @return String return the clientName
   */
  public String getClientName() {
    return clientName;
  }

  /**
   * @param clientName the clientName to set
   */
  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  /**
   * @return String return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
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
   * @return Integer return the Amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * @param Amount the Amount to set
   */
  public void setAmount(double Amount) {
    this.amount = Amount;
  }

}
