package com.juaracoding.ecom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecom.pages.DragDropPage;
import com.juaracoding.ecom.pages.ResizerPage;
import com.juaracoding.ecom.utils.DriverManager;

public class DragDropTest {

  @Test()
  public void dragElementTest() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://jquery-drag-drop-demo.webflow.io/");

    DragDropPage dragDropPage = new DragDropPage(driver);
    dragDropPage.dragAndDrop();

    String actual = dragDropPage.getLabel();
    String expected = "Dropped!";

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test()
  public void resizeElementTest() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://jqueryui.com/resources/demos/resizable/default.html");

    ResizerPage resizerPage = new ResizerPage(driver);
    resizerPage.resizing();

    String expected = "250px";

    Assert.assertNotNull(resizerPage.getHeight(), expected);
    Assert.assertNotNull(resizerPage.getWidth(), expected);

    driverManager.quitDriver();
  }
}
