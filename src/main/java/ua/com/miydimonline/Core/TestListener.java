package ua.com.miydimonline.Core;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ua.com.miydimonline.Utils.WebDriverUtil;

public class TestListener implements ITestListener {

    private WebDriverUtil webDriverUtil;
    private WebDriver webDriver;

    public void onTestStart(ITestResult iTestResult){


    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

        webDriver = ((WebDriverTestBase) iTestResult.getInstance()).webdriver;
        webDriverUtil = new WebDriverUtil(webDriver);
        webDriverUtil.saveScreenshot(iTestResult.getMethod().getMethodName());

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {


    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }


}
