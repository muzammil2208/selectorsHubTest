package tests;

import static setup.testSetup.driverSetup;
import static utilities.extractdata.getData;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.mainPage;
import utilities.reports;
import utilities.screenshot;

public class base {
	 WebDriver driver;
	 mainPage mainPage;
	 screenshot sc;
	 reports report;

	@BeforeTest
	public void setup()
	{
		driver=driverSetup("chrome");
		driver.get(getData("url"));
		report=new reports();
		driver.manage().window().maximize();
		mainPage=new mainPage(driver,report);
		mainPage.closeInitialScreen();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		report.EndTest();
	}
}
