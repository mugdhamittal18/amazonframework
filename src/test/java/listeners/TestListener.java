package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Listener Started");
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASS Listener Triggered");
        test.pass("Test Passed");
        try{
            String screenshot = ScreenshotUtils.captureScreenshot(DriverFactory.getDriver(),result.getName());
            test.addScreenCaptureFromPath(screenshot);
        }
        catch (Exception e){
          e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        try{
            String screenshot = ScreenshotUtils.captureScreenshot(DriverFactory.getDriver(), result.getName());
            test.addScreenCaptureFromPath(screenshot);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Listener Finished");
        extent.flush();
    }
}
