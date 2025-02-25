package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class _11_Listener implements ITestListener {   // or  extends TestListenerAdapter

    public void onStart(ITestContext context) {  // runs only once
        System.out.println("onStart");
    }

    public void onTestStart(ITestResult result) {  // runs before every test method
        System.out.println("onTestStart");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
    }

    public void onFinish(ITestContext context) {  // runs after all test are finished
        System.out.println("onFinish");
    }

}
