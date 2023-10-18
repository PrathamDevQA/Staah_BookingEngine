package MaxBEDemo.MaxBE.pageObject;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MaxBEDemo.MaxBE.abstractComponents.BEAbstractComponents;
import MaxBEDemo.MaxBE.abstractComponents.SingleNightBooking;

public class LandingPage extends BEAbstractComponents{

	SingleNightBooking singleNightBooking = new SingleNightBooking();
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@class='cc-btn cc-allow']")
	private WebElement privayPlicyCloseBtn;
	
	@FindBy(xpath = "//body/div[@class='container bg']/div[@class='be-main']/div/form[@role='form']/div[1]")
	private WebElement datePicker;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchBtn;
	
	public void goToBEsite() {
		driver.get("https://max2uatbe.staah.net/be/indexpackdetail?propertyId=NTc1OA==&individual=true");
	}
	
	
	public void single_room_Single_Night_Booking() {
		BigDecimal sum = new BigDecimal("0.00");
		ArrayList<String> randomDate = singleNightBooking.singleNightBooking();
		String checkInMonthYear = randomDate.get(0);
	    String checkInDate = randomDate.get(1);
	    String checkInDay = randomDate.get(2);
	    String checkoutMonthYear = randomDate.get(3);
	    String checkoutDate = randomDate.get(4);
	    String apiCheckInDate = randomDate.get(5);
	    String apiCheckoutDate = randomDate.get(6);
	    String noofdays=randomDate.get(7);
	    
	    System.out.println("Check-in Month and Year: " + checkInMonthYear);
	    System.out.println("Check-in Date: " + checkInDate);
	    System.out.println("Check-in Day: " + checkInDay);
	    System.out.println("Checkout Month and Year: " + checkoutMonthYear);
	    System.out.println("Checkout Date: " + checkoutDate);
	    System.out.println("API Check-in Date: " + apiCheckInDate);
	    System.out.println("API Checkout Date: " + apiCheckoutDate);
	    System.out.println("nos of nights for Booking :- "+noofdays);
	    
	    try {
			privayPlicyCloseBtn.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datePicker.click();
		
	}
	

}
