package com.juaracoding.ecom.repositories;

import org.openqa.selenium.By;

public class InventoryRepository {
  public static By inventoryItem = By.xpath("//div[@class='inventory_item']");
  public static By inventoryItemName = By.xpath("//div[@class='inventory_item_name']");
  public static By productSortContainer = By.xpath("//select[@class='product_sort_container']");
  public static By addToCart = By.xpath("//*[@id='inventory_container']/div/div[1]/div[3]/button");
  public static By cartSize = By.xpath("//span[contains(@class, 'shopping_cart_badge')]");


}
