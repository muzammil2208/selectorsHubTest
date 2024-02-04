package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.reports;
import utilities.screenshot;

public class IframeScenarios {

	
	WebDriver driver;
	screenshot sc;
	reports report;
	CustomActions action;
	
	public IframeScenarios(WebDriver driver,reports report)
	{
		this.driver=driver;
		this.report=report;
		sc=new screenshot(driver);

		action=new CustomActions(driver,report);
		
	}
}
