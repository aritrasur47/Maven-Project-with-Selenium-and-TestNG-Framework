package resources;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Test
public class ExtentReporterNG {
	static ExtentReports extent;

	public static ExtentReports getTestReport() {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("SYMBO-ULIP Web-Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "//test-output//extent-config.xml"));	

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Aritra Sur", "QA");
		
		return extent;
	}	
}
