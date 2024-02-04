package tests;

import org.testng.annotations.Test;



public class fromfilling extends base {
	
	@Test
	public void formfill() 
	{
		report.createTest("Form Fill test");
		mainPage.enterUsername("jello");
		mainPage.enterPassword("password");
		mainPage.enterCompanyName("tcs");
		mainPage.enterPhoneNumber("998902302032");
		mainPage.clickSubmitBtn();	
	}
	
	
	
}
