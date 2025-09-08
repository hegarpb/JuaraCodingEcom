package com.juaracoding.ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecom.pages.InventoryPage;
import com.juaracoding.ecom.utils.DriverManager;
import com.juaracoding.ecom.utils.LoginUtil;

public class AddToCartTest {
     @Test
  public void addToCartTest()throws InterruptedException{
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");
    LoginUtil.performLogin(driver);

    WebElement btnAddToCart = driver.findElement(InventoryPage.addToCart);
    btnAddToCart.click();

    String actual=btnAddToCart.getText();
    String expected= "REMOVE";

    Assert.assertEquals(actual, expected);

    WebElement cartSize = driver.findElement(InventoryPage.cartSize);
    String actualCartsize =cartSize.getText();
    Assert.assertEquals(actualCartsize, "1");
    driverManager.quitDriver();

  

  }
}
