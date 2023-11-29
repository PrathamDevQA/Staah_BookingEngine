package MaxBEDemo.MaxBE.testComponent;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
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

	public String getScreenshot(String testCaseName, final WebDriver driver2) throws IOException {

//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
		File ScreenshotFile = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
		String desination = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
		File file = new File(desination);
		try {
			FileUtils.copyFile(ScreenshotFile, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return desination;
	}

}
