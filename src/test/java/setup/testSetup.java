package setup;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.InputStream;

public class testSetup {
	static WebDriver driver;
	
	
	public static WebDriver driverSetup(String name)
	{
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			return driver;
			
	}
}		
