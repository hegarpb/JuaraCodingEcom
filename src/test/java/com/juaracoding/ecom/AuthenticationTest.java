package com.juaracoding.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecom.providers.DataTestProvider;

public class AuthenticationTest {

  @Test(dataProvider = "loginDataProvider", dataProviderClass = DataTestProvider.class)
  public void loginTest(String username, String password) throws InterruptedException {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    Thread.sleep(1000);

    WebElement inputUsername = driver.findElement(By.id("user-name"));
    inputUsername.sendKeys(username);

    Thread.sleep(1000);

    WebElement inputPassword = driver.findElement(By.id("password"));
    inputPassword.sendKeys(password);

    Thread.sleep(1000);

    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();

    Thread.sleep(1000);

    String actual = driver.getCurrentUrl();
    String expected = "https://www.saucedemo.com/v1/inventory.html";

    Assert.assertEquals(actual, expected);

    driver.quit();
  }

  @Test()
  public void loginWithInvalidUsername() throws InterruptedException {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    WebElement inputUsername = driver.findElement(By.id("user-name"));
    inputUsername.sendKeys("jonosebastian");

    Thread.sleep(1000);

    WebElement inputPassword = driver.findElement(By.id("password"));
    inputPassword.sendKeys("secret_sauce");

    Thread.sleep(1000);

    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();

    Thread.sleep(1000);

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Username and password do not match any user in this service";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driver.quit();
  }

  @Test()
  public void loginWithInvalidPassword() throws InterruptedException {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    WebElement inputUsername = driver.findElement(By.id("user-name"));
    inputUsername.sendKeys("standard_user");

    Thread.sleep(1000);

    WebElement inputPassword = driver.findElement(By.id("password"));
    inputPassword.sendKeys("secret_sambel");

    Thread.sleep(1000);

    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();

    Thread.sleep(1000);

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Username and password do not match any user in this service";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driver.quit();
  }

  @Test()
  public void loginWithoutPassword() throws InterruptedException {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    WebElement inputUsername = driver.findElement(By.id("user-name"));
    inputUsername.sendKeys("standard_user");

    Thread.sleep(1000);

    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();

    Thread.sleep(1000);

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Password is required";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driver.quit();
  }

  @Test()
  public void loginWithoutUsername() throws InterruptedException {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    WebElement inputPassword = driver.findElement(By.id("password"));
    inputPassword.sendKeys("secret_sauce");

    Thread.sleep(1000);

    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();

    Thread.sleep(1000);

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Username is required";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driver.quit();
  }
}
