package SYMBO.ULIPE2E;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getTestReport();
	ThreadLocal<ExtentTest> extendTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
		// NA
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			extendTest.get().fail(result.getThrowable());

			WebDriver driver = null;
			String testMethodName = result.getMethod().getMethodName();
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());

			extendTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName, driver), result.getMethod().getMethodName());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		extendTest.get().log(Status.SKIP, "Test Skipped ");
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extendTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extendTest.get().log(Status.PASS, "Test Passed " + result.getMethod().getMethodName());
	}

}
