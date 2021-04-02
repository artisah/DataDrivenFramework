package org.example.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    private final Logger logger = LogManager.getLogger(BankManagerLoginTest.class);

    @Test
    public void loginAsManager() throws InterruptedException {

        logger.debug("Inside LoginTest");
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        Thread.sleep(3000);
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Manager Login not successful");
        logger.info("LoginTest test successfull");
        Assert.fail();
    }
}
