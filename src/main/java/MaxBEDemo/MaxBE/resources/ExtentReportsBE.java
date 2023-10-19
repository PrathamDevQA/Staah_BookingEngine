package MaxBEDemo.MaxBE.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBE {
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"//reports//spark.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Booking Engine Test Results");
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pratham Patel");
		return extent;
	}

}
