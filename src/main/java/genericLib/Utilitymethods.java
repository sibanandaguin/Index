package genericLib;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
	public static WebDriverWait wait = new WebDriverWait(driver,20);
	
	
	public static void waitForElementDisplayed(WebElement element) throws Exception
	{
		for(int i=0;i<10;i++)
		{
            try{
                element.isDisplayed();
                break;
            }
            catch(Exception e)
            {
            	Utilitymethods.DelayBy(1);

            }  
		}
	}
	
	public static void waitForElementDisplayed(String xpath) throws Exception
	{
		for(int i=0;i<10;i++)
		{
            try{
                driver.findElement(By.xpath(xpath)).isDisplayed();
                break;
            }
            catch(Exception e)
            {
            	Utilitymethods.DelayBy(1);

            }  
		}
	}
	public static boolean isenabled(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).isEnabled();
	}
	public static boolean isenabled(WebElement element)
	{
		return element.isEnabled();
	}
	
	public static boolean isElementDisplayed(String xpath)
	{
		int count=driver.findElements(By.xpath(xpath)).size();
		if(count==0)
		 {
			AppLogger.logger.info("Element does not Exist in the WebPage.");
			return false;
		 }
		else if(count==1)
		{
			return true;
		}
		else
		{
			AppLogger.logger.info("Multiple xpath found in the WebPage.");
			return false;
		}
	}
	public static boolean isElementDisplayed(WebElement element)
	{
		try {
			element.isDisplayed();
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	//WebDriver explicitly wait for element clickable
	public static void waitForClickable(WebElement wb) 
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
		waitForClickable(element);
		element.click();
		
	}
	public static void elementclick(String xpath)
	{
		WebElement element=driver.findElement(By.xpath(xpath));
		waitForClickable(element);
		element.click();
		
	}
	
	public static void DelayBy(int TimeInSec) throws Exception
	{
		int TimeInMiliSec=TimeInSec*1000;
		Thread.sleep(TimeInMiliSec);
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
	public static boolean checkColor(WebElement wb,String colorhex,String elemnetName )
	{
		
		String rgbcolor = wb.getCssValue("background-color");
		String hex = Color.fromString(rgbcolor).asHex();
		if(hex.equals(colorhex))
		{
			AppLogger.logger.info(elemnetName+"'s color is displayed as Expected.");
			return true;
		}
		else {
			AppLogger.logger.info(elemnetName+"'s color is not displayed as Expected.");
			return false;
			}
	}
	
	
	
}