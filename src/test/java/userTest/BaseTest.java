package userTest;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import genericLib.AppLogger;
import genericLib.Browser;
import genericLib.GlobalEntitie;
import genericLib.ScreenshotClass;
import genericLib.SentEmail;
import genericLib.Utilitymethods;
import genericLib.ExcelLib;
import pageObjectRepository.CommonPage;
import pageObjectRepository.LoginPage;

public class BaseTest
{
	
		public static ExcelLib xls = new ExcelLib(System.getProperty("user.dir")+"\\src\\test\\resources\\Test-Cases.xlsx");
		public static WebDriver driver;
		public ExtentReports reports;
		public ExtentTest test;
		public ExtentHtmlReporter htmlreporter;
		

		
		
		@BeforeClass
		//Before class contain lunching browser,extent report setup,login
		public void primarySetup() 
		{
			AppLogger.logger.info("================LogStarted=================");
			
			   // For lunching Browser
			   driver=Browser.getBrowser();
			   driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			   driver.manage().deleteAllCookies();
			   driver.navigate().to(GlobalEntitie.stgurl);
			   driver.manage().window().maximize();
			   
			   //For Login
			   LoginPage lp=new LoginPage();
			   lp.login(GlobalEntitie.stguserName,GlobalEntitie.stgpassword);
			   AppLogger.logger.info("Login Successful.");
			   
		}
		@BeforeMethod
		public void register(Method method)
		{
			String testName =method.getName();
			test=reports.createTest(testName);
		}
		@BeforeTest
		public void setUp()
		{
			htmlreporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\IndexErpReports\\IndexErp.html"));
			reports=new ExtentReports();
			reports.setSystemInfo("Enironment", "QA");
			reports.attachReporter(htmlreporter);
		}
		@AfterTest
		public void generateReport() throws Exception
		{
			Utilitymethods.DelayBy(2);
			reports.flush();
		}
		
		@AfterMethod
		public void captureStatus(ITestResult result) throws Exception
		{
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(Status.PASS,"The Test Method named as :"+result.getName()+" is Passed.");
				AppLogger.logger.info(result.getName()+" test is Passed.");
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				String screenShotPath=ScreenshotClass.captureScreenShot(driver, result.getName());
				test.fail(MarkupHelper.createLabel(result.getName()+" is failed.", ExtentColor.RED));
				test.fail(result.getThrowable());
				test.fail("Screenshot below:"+test.addScreenCaptureFromPath(screenShotPath));
				AppLogger.logger.info(result.getName()+" test is FAiled.");
				
			}
			else if(result.getStatus()==ITestResult.SKIP)
			{
				throw new SkipException("Skipping the "+result.getName());
			}
		}
		
		
		@AfterClass
		public void closeBrowser() throws Exception
		{
			try {
				CommonPage cp=new CommonPage();
				cp.logout();
				AppLogger.logger.info("Logout Successful");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			driver.quit();
			
			AppLogger.logger.info("================LogEnded=================");
		}
		
		@AfterSuite
		public void afterSuit()
		{
			try {
				//SentEmail.sentEmail();
				AppLogger.logger.info("Email sent Successfully");
			}
			catch(Exception ex){
				ex.printStackTrace();
				AppLogger.logger.info("Could not able to sent email due to some issue");
			}
			
		}
		
	}


