package org.example.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.example.utilities.ExtentReportNG;
import org.example.utilities.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomListeners implements ITestListener {

    ExtentTest test;
    ExtentReports extent= ExtentReportNG.getReportObject();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "test is passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());

        String testMethodName =result.getMethod().getMethodName();

        try {
            test.addScreenCaptureFromPath(TestUtil.getScreenShotPath(testMethodName), result.getMethod().getMethodName());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
