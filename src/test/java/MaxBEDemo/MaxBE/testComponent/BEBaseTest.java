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

		String screenshotPath = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourceF = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
			File file = new File(path);
			String[] reletivePAth = file.toString().split("reports");
			FileUtils.copyFile(sourceF, file);
			screenshotPath = ".\\" + reletivePAth[1];
		} catch (IOException e) {
			System.out.println("Capture failed" + e.getMessage());
		}
		return screenshotPath;

	}

}
