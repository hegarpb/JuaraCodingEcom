package com.juaracoding.ecom;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecom.repositories.JQueryRepository;
import com.juaracoding.ecom.utils.DriverManager;

public class DragDropTest {

  @Test(enabled = false)
  public void dragElementTest() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://jquery-drag-drop-demo.webflow.io/");

    Actions builder = new Actions(driver);
    WebElement draggable = driver.findElement(JQueryRepository.draggable);
    WebElement droppable = driver.findElement(JQueryRepository.droppable);

    builder.dragAndDrop(draggable, droppable).perform();

    String actual = droppable.getText();
    String expected = "Dropped!";

    Assert.assertEquals(actual, expected);

    Thread.sleep(4000);
    driverManager.quitDriver();
  }

  @Test()
  public void resizeElementTest() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
    Actions builder = new Actions(driver);

    WebElement resizer = driver.findElement(JQueryRepository.resizer);

    builder.moveToElement(resizer)
        .pause(Duration.ofSeconds(1))
        .clickAndHold()
        .moveByOffset(100, 100).release()
        .perform();

    JavascriptExecutor jse = (JavascriptExecutor) driver;
    String heightActual = (String) jse.executeScript("return document.querySelector('#resizable').style.height");
    String widthActual = (String) jse.executeScript("return document.querySelector('#resizable').style.width");
    String heightWidthExpected = "250px";

    Assert.assertNotNull(heightActual, heightWidthExpected);
    Assert.assertNotNull(widthActual, heightWidthExpected);

    Thread.sleep(4000);
    driverManager.quitDriver();
  }
}
