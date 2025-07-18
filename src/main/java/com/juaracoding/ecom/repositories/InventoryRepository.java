package com.juaracoding.ecom.repositories;

import org.openqa.selenium.By;

public class InventoryRepository {
  public static By inventoryItem = By.xpath("//div[@class='inventory_item']");
  public static By inventoryItemName = By.xpath("//div[@class='inventory_item_name']");
  public static By productSortContainer = By.xpath("//select[@class='product_sort_container']");
}
