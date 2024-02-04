package tests;

import org.testng.annotations.Test;

public class dropdowns extends base {

	@Test
	public void testAllDropdowns()
	{
		report.createTest("drop-downs test");
		mainPage.howerCheckoutandSelect();
		
	}
}
