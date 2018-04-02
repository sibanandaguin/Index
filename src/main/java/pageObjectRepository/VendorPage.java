package pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.Utilitymethods;
import userTest.VendorModuleTest;

public class VendorPage extends VendorModuleTest{

	public VendorPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@ng-click='venCtrl.addVendor()']")
	private WebElement AddVendorButton;
	
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement VenderSearchField;
	
	@FindBy(xpath="//th[text()='Name']/following-sibling::th[text()='Email']/following-sibling::th[text()='Vendor Type']/following-sibling::th[text()='GSTIN Number']/following-sibling::th[text()='Address']/following-sibling::th[text()='Action']")
	private WebElement VenderGridColumn;
	
	@FindBy(xpath="//span[contains(text(),'VENDOR')]")
	private WebElement VendorPageMarker;
	
	@FindBy(xpath="//h4[contains(text(),'New Vendor')]")
	private WebElement NewVendorHeader;
	
	@FindBy(xpath="//label[text()='Name']/following-sibling::div/input")
	private WebElement NameField;
	
	@FindBy(xpath="//label[text()='Email']/following-sibling::div/input")
	private WebElement EmailField;
	
	@FindBy(xpath="//label[text()='Mobile']/following-sibling::div/input")
	private WebElement MobileField;
	
	@FindBy(xpath="//label[text()='Vendor Type']/following-sibling::div/select")
	private WebElement VendorTypeDropDown;
	
	@FindBy(xpath="//label[text()='GSTIN number']/following-sibling::div/input")
	private WebElement GSTINnofield;
	
	@FindBy(xpath="//label[text()='Address']/following-sibling::div/textarea")
	private WebElement AddressField;
	
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement NewVendorSaveButton;
	
	@FindBy(xpath="//h4[contains(text(),'New Vendor')]/a")
	private WebElement NewVendorformCloseButton;
	
	@FindBy(xpath="//div[text()='New vendor added']")
	private WebElement SuccessToastMessage;
	
	@FindBy(xpath="//div[div[text()='New vendor added']]")
	private WebElement SuccessToastDiv;
	
	
	@FindBy(xpath="//button[text()='×']")
	private WebElement ToastCloser;
	
	
	
	
	
	public boolean vendorPageVerification()
	{
		Utilitymethods.elementIsDisplayed(AddVendorButton,"AddVendorButton");
		Utilitymethods.elementIsDisplayed(VenderSearchField,"VenderSearchField");
		Utilitymethods.elementIsDisplayed(VenderGridColumn,"VenderGridColumn");
		Utilitymethods.elementIsDisplayed(VendorPageMarker,"VendorPageMarker");
		return true;
		
	}
	
	public void addVendor(String name,String email,String mobile,String vendorType,String gstinNumber,String Address)
	{
		Utilitymethods.elementclick(AddVendorButton);
		Utilitymethods.elementIsDisplayed(NewVendorHeader, "NewVendorHeader");
		Utilitymethods.enterText(NameField,name);
		Utilitymethods.enterText(EmailField,email);
		Utilitymethods.enterText(MobileField,mobile);
		Utilitymethods.dropDownSelectionByText(VendorTypeDropDown, vendorType);
		Utilitymethods.enterText(GSTINnofield,gstinNumber);
		Utilitymethods.enterText(AddressField,Address);
		Utilitymethods.isClickable(NewVendorSaveButton);
		Utilitymethods.elementclick(NewVendorSaveButton);
		Utilitymethods.elementIsDisplayed(SuccessToastMessage,"Vendor added toast");
		Utilitymethods.checkColor(SuccessToastDiv,"#51a351","Vender added Success Toast");
		
		Utilitymethods.elementclick(ToastCloser);
		
		
	}
	
	
}
