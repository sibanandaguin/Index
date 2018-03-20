package genericLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import userTest.BaseTest;

public class Utilitymethods extends BaseTest
{
	public static WebDriverWait wait = new WebDriverWait(driver,60);
	
	//WebDriver explicitly wait for element presence
	public static void isElementVisible(WebElement Wb) 
	{
		
		wait.until(ExpectedConditions.visibilityOf(Wb));
	}
	
	//WebDriver explicitly wait for element clickable
	public static void isClickable(WebElement wb) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(wb));
	}
	
	//static method to enter value in text box
	public static void enterText(WebElement element,String value)
	{
		element.clear();
		element.sendKeys(value);
	}
	
	//Static method to click an element
	public static void elementclick(WebElement element)
	{
		isClickable(element);
		element.click();
		
	}
	
	public static void DelayBy(int TimeInSec) throws Exception
	{
		int TimeInMiliSec=TimeInSec*1000;
		Thread.sleep(TimeInMiliSec);
	}
	
	public static String getPath(String path)
	{
		
		return System.getProperty("user.dir")+path;
	}
	
}
