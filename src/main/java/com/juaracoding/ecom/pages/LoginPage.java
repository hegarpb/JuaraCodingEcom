package com.juaracoding.ecom.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  private WebDriver driver;

  @FindBy(id = "user-name")
  private WebElement username;

  @FindBy(id = "password")
  private WebElement password;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  @FindBy(css = "h3[data-test='error']")
  private WebElement errorMessage;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(this.driver, this);
  }

  public void setUsername(String value) {
    username.sendKeys(value);
  }

  public void setPassword(String value) {
    password.sendKeys(value);
  }

  public void clickLoginButton() {
    loginButton.click();
  }

  public String getErrorMessage() {
    try {
      return errorMessage.getText();
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  public void performLogin() {
    setUsername("standard_user");
    setPassword("secret_sauce");
    clickLoginButton();
  }

  public void performLogin(String username, String password) {
    setUsername(username);
    setPassword(password);
    clickLoginButton();
  }

}
