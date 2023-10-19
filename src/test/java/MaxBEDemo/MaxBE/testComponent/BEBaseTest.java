package MaxBEDemo.MaxBE.testComponent;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import MaxBEDemo.MaxBE.BEBaseInitlizedBrowser;
import MaxBEDemo.MaxBE.pageObject.LandingPage;

public class BEBaseTest {
	public WebDriver driver;
	BEBaseInitlizedBrowser init = new BEBaseInitlizedBrowser();
	LandingPage landingPage = new LandingPage(driver);
	
	@BeforeMethod
	public LandingPage lunchApplication() throws IOException {
		driver = init.initBrowser();
		landingPage = new LandingPage(driver);
		landingPage.goToBEsite();
		return landingPage;
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearsDown() {
		driver.close();
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}


}
