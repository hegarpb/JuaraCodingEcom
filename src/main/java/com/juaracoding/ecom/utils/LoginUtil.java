package com.juaracoding.ecom.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginUtil {

  /**
   * Untuk menyediakan pre condition (biasanya test yang membutuhkan login
   * terlebih dahulu).
   * 
   * @param driver
   * @throws InterruptedException
   */
  public static void performLogin(WebDriver driver) throws InterruptedException {
    performLogin(driver, "standard_user", "secret_sauce");
  }

  /**
   * Untuk menyediakan logic yang dapat digunakan untuk testing authentication.
   * 
   * @param driver
   * @param username
   * @param password
   * @throws InterruptedException
   */
  public static void performLogin(WebDriver driver, String username, String password) throws InterruptedException {
    WebElement inputUsername = driver.findElement(By.id("user-name"));
    inputUsername.sendKeys(username);

    Thread.sleep(1000);

    WebElement inputPassword = driver.findElement(By.id("password"));
    inputPassword.sendKeys(password);

    Thread.sleep(1000);

    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();
  }
}
