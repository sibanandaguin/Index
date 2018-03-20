package pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import userTest.BaseTest;

public class LoginPage extends BaseTest{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[text()='INDEX ERP']")
	private WebElement CompanyLogo;
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement Email;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement Password;
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement Loginbutton;
	
	public void login(String a,String b) {
		Email.sendKeys(a);
		Password.sendKeys(b);
		Loginbutton.click();
		
	}
	
	
	
	
}
