package org.example.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    static ExtentReports extent;

    public static ExtentReports getReportObject()
    {

        String path =System.getProperty("user.dir")+"/src/test/resources/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Data Driven Results");
        reporter.config().setDocumentTitle("Test Results");

        extent =new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Arti S");
        return extent;

    }

}
