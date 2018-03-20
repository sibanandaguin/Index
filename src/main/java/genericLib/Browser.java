package genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import userTest.BaseTest;

public class Browser extends BaseTest {

	public static WebDriver getBrowser(){
		
	if(GlobalEntitie.browser.equals("ie")){
		System.setProperty("webdriver.ie.driver", "D:\\IndexErp\\IndexErpAutomation\\src\\main\\resources\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(); 
	}
	
	if(GlobalEntitie.browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "D:\\IndexErp\\IndexErpAutomation\\src\\main\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
	}
	if(GlobalEntitie.browser.equals("firefox")){
		driver = new FirefoxDriver(); 
	}
	return driver;
		
}


}
