package MaxBEDemo.MaxBE.pageTest;

import java.io.IOException;
import org.testng.annotations.Test;

import MaxBEDemo.MaxBE.pageObject.LandingPage;
import MaxBEDemo.MaxBE.testComponent.BEBaseTest;

public class LandingPageTest extends BEBaseTest{
	
	@Test
	public void listingPageTest() throws IOException, InterruptedException {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.single_room_Single_Night_Booking();
		
	}
	
	
	

}
