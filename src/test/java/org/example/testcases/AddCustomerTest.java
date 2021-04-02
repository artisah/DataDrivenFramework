package org.example.testcases;

import org.example.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "test1")
    public void addCustomer(String fName, String lName, String postCode) throws InterruptedException {
        String alertText = "Customer added successfully";
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(fName);
        driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lName);
        driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertText), "Alert not appeared");
        alert.accept();

    }

    @DataProvider(name = "test1")
    public Object[][] getData() {
        String sheetName = "AddCustomerTest";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
            }
        }
        return data;
    }

//    @DataProvider(name="test1")
//    public Object[][] getDataFromDataprovider(){
//        return new Object[][]
//                {
//                        { "Guru99", "India" },
//                        { "Krishna", "UK" },
//                        { "Bhupesh", "USA" }
//                };
//
//    }

}
