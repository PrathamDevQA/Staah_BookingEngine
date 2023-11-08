package MaxBEDemo.MaxBE.pageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MaxBEDemo.MaxBE.pageObject.LandingPage;
import MaxBEDemo.MaxBE.testComponent.BEBaseTest;
import MaxBEDemo.MaxBE.testComponent.BEListeners;
@Listeners(BEListeners.class)
public class LandingPageTest extends BEBaseTest{
	
	@Test
	public void listingPageTest() throws IOException, InterruptedException {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.single_room_Single_Night_Booking();
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		Assert.assertTrue(landingPage.getPerNightRate().contains("PRA"));
		
	}
	
	@Test(groups = "Regression")
	public void test() throws InterruptedException {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.single_room_Single_Night_Booking();
		Assert.assertTrue(landingPage.getPerNightRate().contains("PRA"));
	}
	
}
