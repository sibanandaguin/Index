package genericLib;

import java.io.File;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
	public static void elementIsEnabled(WebElement element,String elementName)
	{
		try
		{
			boolean b=element.isEnabled();
			if(b)
			{
				AppLogger.logger.info(elementName+"is enabled");
			}
		}
		catch(Exception e)
		{
			AppLogger.logger.info(elementName+"is not enabled");
		}
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
	
	public static void elementIsDisplayed(WebElement wb,String elementName)
	{
		try
		{
			
			boolean b=wb.isDisplayed();
			if(b) 
			{
				AppLogger.logger.info(elementName+" is Displayed.");
			}
		}
		catch(NoSuchElementException nse)
		{
			AppLogger.logger.info(elementName+" is not Displayed.");
		}
	}
	
	public static void dropDownSelectionByText(WebElement wb,String text)
	{
		Select sel=new Select(wb);
		sel.selectByVisibleText(text);
	}
	public static String captureScreenShot(WebDriver driver, String ScreenShotName){
		try{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			String dest="C:\\Index\\indexerp\\src\\main\\resources\\Screenshots\\"+ScreenShotName+".png";
			File destination = new File(dest);
			FileUtils.copyFile(Source, destination);
			System.out.println("Screen shot taken");
			return dest;
		}
		catch (Exception e){
			System.out.println("Exception while capturing screen shot"+e.getMessage());
			return e.getMessage();
		}
	}
	public static void checkColor(WebElement wb,String colorhex,String elemnetName )
	{
		
		String rgbcolor = wb.getCssValue("background-color");
		String hex = Color.fromString(rgbcolor).asHex();
		if(hex.equals(colorhex))
		{
			AppLogger.logger.info(elemnetName+"'s color is displayed as Expected.");
		}else {AppLogger.logger.info(elemnetName+"'s color is not displayed as Expected.");}
	}
}