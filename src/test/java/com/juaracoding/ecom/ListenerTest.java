package com.juaracoding.ecom;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

  @Override
  public void onStart(ITestContext context) {
    System.out.println("on start: " + context.getName());
  }

  @Override
  public void onTestStart(ITestResult result) {
    System.out.println("on test start: " + result.getName());
  }

  @Override
  public void onTestFailure(ITestResult result) {
    System.out.println("on test fail: " + result.getName());
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    System.out.println("on test skip: " + result.getName());
  }

}
