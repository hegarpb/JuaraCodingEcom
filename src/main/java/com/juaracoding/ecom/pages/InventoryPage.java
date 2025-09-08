package com.juaracoding.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
  private WebDriver driver;
  public static By inventoryItem = By.xpath("//div[@class='inventory_item']");
  public static By inventoryItemName = By.xpath("//div[@class='inventory_item_name']");
  public static By productSortContainer = By.xpath("//select[@class='product_sort_container']");
  public static By addToCart = By.xpath("//*[@id='inventory_container']/div/div[1]/div[3]/button");
  public static By cartSize = By.xpath("//span[contains(@class, 'shopping_cart_badge')]");


  public InventoryPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getCurrentURL() {
    return driver.getCurrentUrl();
  }
}
