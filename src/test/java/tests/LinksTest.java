package tests;

import org.testng.annotations.Test;

public class LinksTest extends base {
	
	
	@Test
	public void checkAllLinks()
	{
		report.createTest("link test");
		mainPage.TestallLinks();
	}
		
}
