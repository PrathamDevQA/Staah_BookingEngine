package MaxBEDemo.MaxBE.abstractComponents;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class SingleNightBooking {
	
	public ArrayList<String> singleNightBooking() {
		ArrayList<String> arr = new ArrayList<String>();
		LocalDate currentDate = LocalDate.now();
		Random random = new Random();
		int randomDay = random.nextInt(30)+1;
		LocalDate checkInDate = currentDate.plusDays(randomDay);
		int randomNight = random.nextInt(1)+1;
		LocalDate checkOutDate = checkInDate.plusDays(randomNight);
		DayOfWeek dayOfWeek = checkInDate.getDayOfWeek();
 		
		String checkInMonthYear = checkInDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
		arr.add(checkInMonthYear);
		String checkInDateFormatted = checkInDate.format(DateTimeFormatter.ofPattern("d"));
		arr.add(checkInDateFormatted);
		String weekDay = dayOfWeek.toString();
		arr.add(weekDay);
		String checkoutMonthYear = checkOutDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
	    arr.add(checkoutMonthYear);
	    String checkoutDateFormatted = checkOutDate.format(DateTimeFormatter.ofPattern("d"));
	    arr.add(checkoutDateFormatted);
	    String apiCheckInDateProvider = checkInDate.format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy"));
	    arr.add(apiCheckInDateProvider);
	    String apiCheckoutDateProvider = checkOutDate.format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy"));
	    arr.add(apiCheckoutDateProvider);
	    arr.add(Integer.toString(randomNight));     // Add random nights to the last index of arr
	    LocalDate apiCheckInDateProviderPlusOneDay = checkInDate.plusDays(1);
	    String apiCheckInDateProviderPlusOneDayFormatted = apiCheckInDateProviderPlusOneDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    arr.add(apiCheckInDateProviderPlusOneDayFormatted);
	    return arr;
		
	}
	
	//Test above 
	public void testabove() throws ParseException {						
		 ArrayList<String> randomDates = singleNightBooking();
		    String checkInMonthYear = randomDates.get(0);
		    String checkInDate = randomDates.get(1);
		    String checkInDay = randomDates.get(2);
		    String checkoutMonthYear = randomDates.get(3);
		    String checkoutDate = randomDates.get(4);
		    String apiCheckInDate = randomDates.get(5);
		    String apiCheckoutDate = randomDates.get(6);
		    String noofdays=randomDates.get(7);
		    
		    System.out.println("Check-in Month and Year: " + checkInMonthYear);
		    System.out.println("Check-in Date: " + checkInDate);
		    System.out.println("Check-in Day: " + checkInDay);
		    System.out.println("Checkout Month and Year: " + checkoutMonthYear);
		    System.out.println("Checkout Date: " + checkoutDate);
		    System.out.println("API Check-in Date: " + apiCheckInDate);
		    System.out.println("API Checkout Date: " + apiCheckoutDate);
		    System.out.println("nos of nights for Booking :- "+noofdays);
	}


}
