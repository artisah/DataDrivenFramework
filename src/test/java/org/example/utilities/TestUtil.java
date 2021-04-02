package org.example.utilities;

import org.apache.commons.io.FileUtils;
import org.example.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static String screenshotName;

//    public static void captureScreenshot() {
//        //Take the screenshot
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        Date d = new Date();
//        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//
//        //Copy the file to a location and use try catch block to handle exception
//        try {
//            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + screenshotName + ".jpg"));
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }


//    public static void captureScreenshot() {
//        //Take the screenshot
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        Date d = new Date();
//        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//
//        //Copy the file to a location and use try catch block to handle exception
//        try {
//            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + screenshotName + ".jpg"));
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public static String getScreenShotPath(String testCaseName) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/src/test/resources/reports/" + testCaseName + ".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;

    }
}
