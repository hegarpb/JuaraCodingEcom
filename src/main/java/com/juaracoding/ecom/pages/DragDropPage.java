package com.juaracoding.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {
  private By draggable = By.id("draggable");
  private By droppable = By.id("droppable");
  private WebDriver driver;
  private Actions builder;

  public DragDropPage(WebDriver driver) {
    this.driver = driver;
    builder = new Actions(driver);
  }

  public void dragAndDrop() {
    builder.dragAndDrop(
        driver.findElement(draggable),
        driver.findElement(droppable)).perform();
  }

  public String getLabel() {
    try {
      return driver.findElement(droppable).getText();
    } catch (NoSuchElementException e) {
      return null;
    }
  }

}
