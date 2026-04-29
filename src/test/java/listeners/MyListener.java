package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.ScreenShotUtil;

public class MyListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed: " + result.getName());

        try {
            ScreenShotUtil.takeScreenshot(result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}