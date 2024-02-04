package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.RestAssured;
import utilities.reports;
import utilities.screenshot;

public class mainPage{
	WebDriver driver;

	reports report;
	WebDriverWait wait;
	CustomActions action;
	RestAssured response;
	Actions act;
	
	@FindBy(xpath="//input[@title=\"Email\"]")
	WebElement usernameField;
	
	@FindBy(xpath="//input[@id=\"pass\"]")
	WebElement passowrdField;
	
	@FindBy(xpath="(//input[@name=\"company\"])[1]")
	WebElement companyField;
	
	@FindBy(xpath="(//input[@name=\"mobile number\"])[1]")
	WebElement numberField;
	
	@FindBy(xpath="//input[@value=\"Submit\"]")
	WebElement submitBtn;
	
	@FindBy(xpath="//img[@title=\"Close\"]")
	WebElement closeBtn;
	
	@FindBy(xpath="//button[text()=\"Checkout here\"]")
	WebElement checkoutBtn;
	

	
	public mainPage(WebDriver driver,reports report)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.report=report;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		action=new CustomActions(driver,report);
		act=new Actions(driver);
		
	}
	
	public void enterUsername(String username)
	{
		action.enterText(usernameField, username);
		
	}
	
	public void enterPassword(String password)
	{
		action.enterText(passowrdField, password);
	}
	public void clickSubmitBtn()
	{
		action.click(submitBtn);
	}
	
	public void enterCompanyName(String companyName)
	{
		action.enterText(companyField, companyName);
	}
	public void enterPhoneNumber(String phoneNumber)
	{
		action.enterText(numberField,phoneNumber);
	}
	public void closeInitialScreen()
	{
		wait.until(ExpectedConditions.visibilityOf(closeBtn));
		closeBtn.click();
	}
	
	public void checkAllCheckboxes()
	{
		List<WebElement> boxes=new ArrayList<WebElement>();
		boxes=driver.findElements(By.xpath("//table[@id=\"resultTable\"]//input[@type=\"checkbox\"]"));
		for(WebElement element:boxes)
			action.click(element);
	}
	
	public void TestallLinks()
	{
		
		Response res;
		List<WebElement> links=new ArrayList<WebElement>();
		links=driver.findElements(By.tagName("a"));
		for(WebElement link:links)
		{
			try {
			res=RestAssured.get(link.getAttribute("href"));
			String ls=link.getAttribute("href");
			if(res.getStatusCode()==200)
			{
				
				System.out.println(ls+" is passed with status code is "+res.statusCode());
				
			}
			else
				System.out.println(ls+" is failed with status code is "+res.statusCode());
			}
			catch(Exception e)
			{
				System.out.println("link is null");
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void howerCheckoutandSelect()
	{
		
		
		ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
		ArrayList<WebElement> links=new ArrayList<WebElement>(driver.findElements(By.xpath("//div[@class=\"dropdown-content\"]/a")));
		for(WebElement link:links)
		{
			action.hower(checkoutBtn);
			action.click(link);
			driver.switchTo().window(handles.get(0));
		}
		
	}
	
	
	
	
}
