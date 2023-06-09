package com.puc.newspaper.DTO;

public class UserRequest {

  private String name;
  private String email;
  private String password;
  private String plan;
  private String typePlan;

  public UserRequest(String name, String email, String password, String plan, String typePlan) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.plan = plan;
    this.typePlan = typePlan;
  }

  public UserRequest() {
  }

  /**
   * @return String return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
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
   * @return String return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
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

}
