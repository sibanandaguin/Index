package genericLib;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import userTest.BaseTest;


public class ScreenshotClass extends BaseTest {
	
	public static String captureScreenShot(WebDriver driver, String ScreenShotName){
		try{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			String dest="D:\\IndexErp\\IndexErpAutomation\\src\\main\\resources\\Screenshots\\"+ScreenShotName+".png";
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
	}


