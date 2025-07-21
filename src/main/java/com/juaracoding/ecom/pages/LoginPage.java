package com.juaracoding.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  private WebDriver driver;

  private By usernameField = By.id("user-name");
  private By passwordField = By.id("password");
  private By loginButton = By.id("login-button");
  private By errorMessage = By.cssSelector("h3[data-test='error']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setUsername(String value) {
    driver.findElement(usernameField).sendKeys(value);
  }

  public void setPassword(String value) {
    driver.findElement(passwordField).sendKeys(value);
  }

  public void clickLoginButton() {
    driver.findElement(loginButton).click();
  }

  public String getErrorMessage() {
    try {
      return driver.findElement(errorMessage).getText();
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
