package MaxBEDemo.MaxBE.abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BEAbstractComponents {
	
	public WebDriver driver;

	public BEAbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	

}
