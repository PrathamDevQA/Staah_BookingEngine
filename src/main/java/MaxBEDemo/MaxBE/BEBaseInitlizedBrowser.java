package MaxBEDemo.MaxBE;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BEBaseInitlizedBrowser {

	public WebDriver driver;

	public WebDriver initBrowser() throws IOException {

		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/MaxBEDemo/MaxBE/resources/GlobalData.properties");
		props.load(fis);

		String browserName = System.getProperty("bowser") != null ? System.getProperty("browser")
				: props.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			ChromeOptions ops = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				ops.addArguments("--headless");
			}
			driver = new ChromeDriver();
		}else if(browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox allow-same-origin; default-src 'self';");
		System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "");
		System.clearProperty("hudson.model.DirectoryBrowserSupport.CSP");
		System.getProperty("hudson.model.DirectoryBrowserSupport.CSP");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.get("https://staahmax.staah.net/be/indexpackdetail?propertyId=NTc1OA==&individual=true");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

}
