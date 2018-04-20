package pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.Utilitymethods;
import userTest.BaseTest;

public class CommonPage extends BaseTest
{	
	
	public CommonPage()
	{
		PageFactory.initElements(driver, this);
	}
	public Utilitymethods method=new Utilitymethods();
	
	@FindBy(xpath="//i[@class='fa fa-sign-out']")
	private WebElement Logoutlink;
	
	@FindBy(xpath="//span[text()='Category']")
	private WebElement CategorySpan;
	@FindBy(xpath="//span[text()='Vendor']")
	private WebElement VendorSpan;
	
	@FindBy(xpath="//button[@ng-click='venCtrl.addVendor()']")
	private WebElement AddVendorButton;
	
	
	
	
	//Method to logout
	public void logout() throws Exception 
	
	{
		Utilitymethods.DelayBy(10);
		Utilitymethods.elementclick(Logoutlink);
	}
	
	//method to clickCategorySpan
	public void clickCategorySpan() throws Exception
	{
		Utilitymethods.DelayBy(2);
		Utilitymethods.elementclick(CategorySpan);
	}
	
	public void goToVendorPage() throws Exception
	{
		Utilitymethods.elementclick(VendorSpan);
		
	}
	
}
