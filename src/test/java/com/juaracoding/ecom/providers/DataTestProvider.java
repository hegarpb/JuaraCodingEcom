package com.juaracoding.ecom.providers;

import org.testng.annotations.DataProvider;

import com.juaracoding.ecom.utils.ExcelUtils;

public class DataTestProvider {

  @DataProvider(name = "loginDataProvider")
  public Object[][] loginDataProvider() {
    String excelPath = "src/test/resources/DataTestProvider.xlsx";
    ExcelUtils excel = new ExcelUtils(excelPath, "Sheet1");

    int rowCount = excel.getRowCount();
    int colCount = excel.getColCount();

    Object data[][] = new Object[rowCount - 1][colCount];

    for (int i = 1; i < rowCount; i++) {
      for (int j = 0; j < colCount; j++) {
        data[i - 1][j] = excel.getCellData(i, j);
      }
    }

    return data;
  }

}
