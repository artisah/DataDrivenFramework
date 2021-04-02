package org.example.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utilities.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    private final Logger logger = LogManager.getLogger(TestBase.class);
    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
    public static WebDriverWait wait;

    @BeforeSuite
    public void setUp() throws InterruptedException {

        //Load properties file config and OR
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            OR.load(fis);
            logger.error("Object reposierty (OR) Configuration file loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fis);
            logger.debug("config  Configuration file loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (config.get("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/executables/chromedriver");
            driver = new ChromeDriver();
            logger.debug("chrome webdrive launched");
        } else if (config.get("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./src/test/resources/executables/geckodriver");
            driver = new FirefoxDriver();
            logger.debug("Firefox driver lauched");
        }

        driver.get(config.getProperty("testsiteurl"));
        logger.debug("navigated to" +  config.getProperty("testsiteurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }



    public boolean isElementPresent(By elementToFind) {

        try {
            driver.findElement(elementToFind);
            return true;
        }  catch (NoSuchElementException ex) {
            return false;
        }

    }

    @AfterSuite
    public void teatDown() {

        if (driver != null) {
            driver.quit();
        }

        logger.error("driver quit successfully");

    }



}

