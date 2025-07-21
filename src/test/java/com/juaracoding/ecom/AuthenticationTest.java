package com.juaracoding.ecom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecom.pages.InventoryPage;
import com.juaracoding.ecom.pages.LoginPage;
import com.juaracoding.ecom.providers.DataTestProvider;
import com.juaracoding.ecom.utils.DriverManager;

public class AuthenticationTest {

  @Test(dataProvider = "loginDataProvider", dataProviderClass = DataTestProvider.class)
  public void loginTest(String username, String password, String errorMessage) throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginPage loginPage = new LoginPage(driver);

    loginPage.performLogin(username, password);

    if (loginPage.getErrorMessage() != null) {
      String actual = loginPage.getErrorMessage();
      Assert.assertEquals(actual, errorMessage);
    } else {
      InventoryPage inventoryPage = new InventoryPage(driver);
      String actual = inventoryPage.getCurrentURL();
      String expected = "https://www.saucedemo.com/v1/inventory.html";
      Assert.assertEquals(actual, expected);
    }

    driverManager.quitDriver();
  }
}
