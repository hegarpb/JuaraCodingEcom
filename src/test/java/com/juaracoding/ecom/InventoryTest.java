package com.juaracoding.ecom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.juaracoding.ecom.repositories.InventoryRepository;
import com.juaracoding.ecom.utils.DriverManager;
import com.juaracoding.ecom.utils.LoginUtil;

public class InventoryTest {

  @Test()
  public void productDisplayTest() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver);

    int expected = 6;
    int actual = driver.findElements(InventoryRepository.inventoryItem).size();

    Assert.assertEquals(actual, expected, "Jumlah produk tidak sesuai expektasi.");
    driverManager.quitDriver();
  }

  @Test
  public void productSortFeatureTest() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");
    LoginUtil.performLogin(driver);

    Select select = new Select(driver.findElement(
        InventoryRepository.productSortContainer));

    select.selectByValue("az");

    List<WebElement> items = driver.findElements(InventoryRepository.inventoryItemName);
    List<String> actualTitles = new ArrayList<String>();

    for (WebElement item : items) {
      actualTitles.add(item.getText());
    }

    List<String> expectedTitles = new ArrayList<String>(actualTitles);
    Collections.sort(expectedTitles);

    Assert.assertEquals(actualTitles, expectedTitles);
    driverManager.quitDriver();
  }
}
