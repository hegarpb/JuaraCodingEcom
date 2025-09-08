package com.juaracoding.ecom;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ListenerTest implements ITestListener {

    // Untuk simpan WebDriver dari test
    public static WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=== Suite Start: " + context.getName() + " ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== Suite Finish: " + context.getName() + " ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[START] Test Case: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[PASS] Test Case: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[FAIL] Test Case: " + result.getName());
        takeScreenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[SKIP] Test Case: " + result.getName());
    }

    // Helper method untuk screenshot
    public void takeScreenshot(String methodName) {
        if (driver != null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File("screenshots/" + methodName + "_" + timestamp + ".png"));
                System.out.println("Screenshot saved for test: " + methodName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
