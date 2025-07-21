package com.juaracoding.ecom.pages;

import org.openqa.selenium.WebDriver;

public class InventoryPage {
  private WebDriver driver;

  public InventoryPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getCurrentURL() {
    return driver.getCurrentUrl();
  }
}
