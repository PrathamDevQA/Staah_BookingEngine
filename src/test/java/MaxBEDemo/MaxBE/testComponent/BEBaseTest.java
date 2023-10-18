package MaxBEDemo.MaxBE.testComponent;

import java.io.IOException;

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

}
