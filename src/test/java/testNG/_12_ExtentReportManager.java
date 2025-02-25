package testNG;

import org.testng.ITestListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class _12_ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  // populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods

	public void onStart(ITestContext context) {
			
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\myReport.html");	//specify location of the report
		sparkReporter.config().setDocumentTitle("Automation Report");	// TiTle of report
		sparkReporter.config().setReportName("Functional Testing");		// name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Pavan");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name", "Chrome");
	}


	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, result.getName() + " Test case PASSED "); // update status p/f/s
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, result.getName() + "Test case FAILED");
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, result.getName() + "Test case SKIPPED");
	}

	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
