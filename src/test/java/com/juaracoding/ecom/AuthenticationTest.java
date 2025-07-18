package com.juaracoding.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecom.providers.DataTestProvider;
import com.juaracoding.ecom.utils.DriverManager;
import com.juaracoding.ecom.utils.LoginUtil;

public class AuthenticationTest {

  @Test(dataProvider = "loginDataProvider", dataProviderClass = DataTestProvider.class)
  public void loginTest(String username, String password) throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, username, password);

    String actual = driver.getCurrentUrl();
    String expected = "https://www.saucedemo.com/v1/inventory.html";

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test()
  public void loginWithInvalidUsername() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");
    LoginUtil.performLogin(driver, "jonosebastian", "secret_sauce");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Username and password do not match any user in this service";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test()
  public void loginWithInvalidPassword() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, "standard_user", "secret_sambel");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Username and password do not match any user in this service";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test()
  public void loginWithoutPassword() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, "standard_user", "");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Password is required";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test()
  public void loginWithoutUsername() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, "", "secret_sauce");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Username is required";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }
}
