package MaxBEDemo.MaxBE.testComponent;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
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
		String path = System.getenv("WORKSPACE") + "/reports/" + testCaseName + ".png";
		File file = new File(path);
		try {
		FileUtils.copyFile(source, file);
		} catch(IOException e) {
			System.out.println("Capture failed"+e.getMessage());
		}
		return path;

	}

}
