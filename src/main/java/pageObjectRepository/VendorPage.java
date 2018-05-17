package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.AppLogger;
import genericLib.Utilitymethods;
import userTest.VendorModuleTest;

public class VendorPage extends VendorModuleTest{

	public VendorPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@ng-click='venCtrl.addVendor()']")
	private WebElement AddVendorButton;
	
	@FindBy(xpath="(//i[@class='fa fa-credit-card text-success'])[2]")
	private WebElement VendorCardSymbol;
	
	@FindBy(xpath="//b[contains(text(),'Please Click on ')]")
	private WebElement VendorCardInfobox;
	
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
	private WebElement SuccessToastMessageForVendorAdded;
	
	@FindBy(xpath="//div[div[text()='New vendor added']]")
	private WebElement SuccessToastDivForVendorAdded;
	
	@FindBy(xpath="//div[text()='New vendor updated']")
	private WebElement SuccessToastMessageForVendorUpdated;
	
	@FindBy(xpath="//div[div[text()='New vendor updated']]")
	private WebElement SuccessToastDivForVendorUpdated;

	@FindBy(xpath="//button[text()='Update']")
	private WebElement VendorUpdateButton;

	@FindBy(xpath="//b[text()='Confirm']")
	private WebElement VendorConfirmDialogHeader;

	@FindBy(xpath="//b[text()='Do you want to Delete ?']")
	private WebElement DeleteVendorConfirmMessage;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement VendorDeleteCancelButton;
	
	@FindBy(xpath="//button[text()='Ok']")
	private WebElement VendorDeleteOKButton;
	
	@FindBy(xpath="//div[text()='Vendor  Deleted']")
	private WebElement VendorDeletedSusseccToast;
	
	@FindBy(xpath="//div[div[text()='Vendor  Deleted']]")
	private WebElement VendorDeletedSusseccToastDiv;
	
	@FindBy(xpath="//div[div[text()='Email Already Exists']]")
	private WebElement VendorAlreadyExistToastDiv;
	
	@FindBy(xpath="//div[text()='Email Already Exists']")
	private WebElement VendorAlreadyExistToast;
	
	@FindBy(xpath="(//button[text()='×'])[1]")
	private WebElement ToastCloser;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement SearchTextBox;
	
	@FindBy(xpath="//b[text()='VENDOR CREDIT/DEBIT']")
	private WebElement VendorDeditCreditHeader;
	
	@FindBy(xpath="//th[text()='Date']/following-sibling::th[text()='Invoice No']/following-sibling::th[text()='CGST']/following-sibling::th[text()='SGST']/following-sibling::th[text()='IGST']/following-sibling::th[text()='Total Amount']")
	private WebElement CreditDebitGridHeader;

	
	
	
	
	public boolean vendorPageVerification()
	{
		Utilitymethods.isElementDisplayed(AddVendorButton);
		Utilitymethods.isElementDisplayed(VenderSearchField);
		Utilitymethods.isElementDisplayed(VenderGridColumn);
		Utilitymethods.isElementDisplayed(VendorPageMarker);
		Utilitymethods.isElementDisplayed(VendorCardSymbol);
		Utilitymethods.isElementDisplayed(VendorCardInfobox);
		return true;
		
	}
	public boolean addVendor(String name,String email,String mobile,String vendorType,String gstinNumber,String address) throws Exception
	{
		Utilitymethods.elementclick(AddVendorButton);
		Utilitymethods.waitForElementDisplayed(NewVendorHeader);
		Utilitymethods.enterText(NameField,name);
		Utilitymethods.enterText(EmailField,email);
		Utilitymethods.enterText(MobileField,mobile);
		Utilitymethods.dropDownSelectionByText(VendorTypeDropDown, vendorType);
		Utilitymethods.enterText(GSTINnofield,gstinNumber);
		Utilitymethods.enterText(AddressField,address);
		Utilitymethods.elementclick(NewVendorSaveButton);
		Utilitymethods.isElementDisplayed(SuccessToastMessageForVendorAdded);
		Utilitymethods.checkColor(SuccessToastDivForVendorAdded,"#51a351","Vender added Success Toast");
		Utilitymethods.elementclick(ToastCloser);
		return Utilitymethods.isElementDisplayed("//td[contains(text(),'"+name+"')]/following-sibling::td[text()='"+email+"']/following-sibling::td[text()='"+mobile+"']/following-sibling::td[text()='"+vendorType+"']/following-sibling::td[text()='"+gstinNumber+"']/following-sibling::td[text()='"+address+"']");
		
	}
	
	public boolean editVendor(String existingVendorName,
			String name,String email,String mobile,
			String vendorType,String gstinNumber,String address) throws Exception
	{
	
		if(Utilitymethods.isElementDisplayed("//td[contains(text(),'"+existingVendorName+"')]"))
		{
			Utilitymethods.elementclick("//td[contains(text(),'"+existingVendorName+"')]/following-sibling::td/a/i[contains(@class,'edit')]");
			Utilitymethods.waitForElementDisplayed(NewVendorHeader);
			Utilitymethods.enterText(NameField,name);
			Utilitymethods.enterText(EmailField,email);
			Utilitymethods.enterText(MobileField,mobile);
			Utilitymethods.dropDownSelectionByText(VendorTypeDropDown, vendorType);
			Utilitymethods.enterText(GSTINnofield,gstinNumber);
			Utilitymethods.enterText(AddressField,address);
			Utilitymethods.elementclick(VendorUpdateButton);
			Utilitymethods.isElementDisplayed(SuccessToastMessageForVendorUpdated);
			Utilitymethods.checkColor(SuccessToastDivForVendorUpdated,"#51a351","Vender added Success Toast");
			Utilitymethods.elementclick(ToastCloser);
			return Utilitymethods.isElementDisplayed("//td[contains(text(),'"+name+"')]/following-sibling::td[text()='"+email+"']/following-sibling::td[text()='"+mobile+"']/following-sibling::td[text()='"+vendorType+"']/following-sibling::td[text()='"+gstinNumber+"']/following-sibling::td[text()='"+address+"']");
		}
		else {
			AppLogger.logger.info(existingVendorName+" named vendor doesnot exist.");
			return false;
		}
		
	}
	public boolean editVendorWithoutUpdated(String name,String email,String mobile,
			String vendorType,String gstinNumber,String address) throws Exception
	{
		if(Utilitymethods.isElementDisplayed("//td[contains(text(),'"+name+"')]"))
		{
			Utilitymethods.elementclick("//td[contains(text(),'"+name+"')]/following-sibling::td/a/i[contains(@class,'edit')]");
			Utilitymethods.waitForElementDisplayed(NewVendorHeader);
			Utilitymethods.elementclick(VendorUpdateButton);
			Utilitymethods.isElementDisplayed(SuccessToastMessageForVendorUpdated);
			Utilitymethods.checkColor(SuccessToastDivForVendorUpdated,"#51a351","Vender added Success Toast");
			Utilitymethods.elementclick(ToastCloser);
			return Utilitymethods.isElementDisplayed("//td[contains(text(),'"+name+"')]/following-sibling::td[text()='"+email+"']/following-sibling::td[text()='"+mobile+"']/following-sibling::td[text()='"+vendorType+"']/following-sibling::td[text()='"+gstinNumber+"']/following-sibling::td[text()='"+address+"']");
		}
		else 
		{
			AppLogger.logger.info(name+" named vendor doesnot exist.");
			return false;
		}
	}
	
	public boolean deleteVendor(String existingVendorName) throws Exception
	{
		if(Utilitymethods.isElementDisplayed("//td[contains(text(),'"+existingVendorName+"')]"))
		{
			Utilitymethods.elementclick("//td[contains(text(),'"+existingVendorName+"')]/following-sibling::td/a[contains(@ng-click,'delete')]");
			Utilitymethods.waitForElementDisplayed(VendorConfirmDialogHeader);
			Utilitymethods.waitForElementDisplayed(DeleteVendorConfirmMessage);
			Utilitymethods.elementclick(VendorDeleteOKButton);
			Utilitymethods.isElementDisplayed(VendorDeletedSusseccToast);
			Utilitymethods.checkColor(VendorDeletedSusseccToastDiv,"#51a351","Vender added Success Toast");
			Utilitymethods.elementclick(ToastCloser);
			return Utilitymethods.isElementDisplayed("//td[contains(text(),'"+existingVendorName+"')]");
		}
		else {
			AppLogger.logger.info(existingVendorName+" named vendor doesnot exist.");
			return false;
		}
		
	}
	public boolean CancelOndeleteVendor(String existingVendorName) throws Exception
	{
		if(Utilitymethods.isElementDisplayed("//td[contains(text(),'"+existingVendorName+"')]"))
		{
			Utilitymethods.elementclick(driver.findElement(By.xpath("//td[contains(text(),'"+existingVendorName+"')]/following-sibling::td/a[contains(@ng-click,'delete')]")));
			Utilitymethods.waitForElementDisplayed(VendorConfirmDialogHeader);
			Utilitymethods.waitForElementDisplayed(DeleteVendorConfirmMessage);
			Utilitymethods.elementclick(VendorDeleteCancelButton);
			return Utilitymethods.isElementDisplayed("//td[contains(text(),'"+existingVendorName+"')]");
		}
		else {
			AppLogger.logger.info(existingVendorName+" named vendor doesnot exist.");
			return false;
		}
		
	}

	public boolean addDuplicateVendor(String name,String email,String mobile,String vendorType,String gstinNumber,String address) throws Exception
	{
		Utilitymethods.elementclick(AddVendorButton);
		Utilitymethods.waitForElementDisplayed(NewVendorHeader);
		Utilitymethods.enterText(NameField,name);
		Utilitymethods.enterText(EmailField,email);
		Utilitymethods.enterText(MobileField,mobile);
		Utilitymethods.dropDownSelectionByText(VendorTypeDropDown, vendorType);
		Utilitymethods.enterText(GSTINnofield,gstinNumber);
		Utilitymethods.enterText(AddressField,address);
		Utilitymethods.elementclick(NewVendorSaveButton);
		Utilitymethods.isElementDisplayed(SuccessToastMessageForVendorAdded);
		Utilitymethods.checkColor(SuccessToastDivForVendorAdded,"#51a351","Vender added Success Toast");
		Utilitymethods.elementclick(ToastCloser);
		Utilitymethods.waitForElementDisplayed("//td[contains(text(),'"+name+"')]/following-sibling::td[text()='"+email+"']/following-sibling::td[text()='"+mobile+"']/following-sibling::td[text()='"+vendorType+"']/following-sibling::td[text()='"+gstinNumber+"']/following-sibling::td[text()='"+address+"']");
		Utilitymethods.elementclick(AddVendorButton);
		Utilitymethods.waitForElementDisplayed(NewVendorHeader);
		Utilitymethods.enterText(NameField,name);
		Utilitymethods.enterText(EmailField,email);
		Utilitymethods.enterText(MobileField,mobile);
		Utilitymethods.dropDownSelectionByText(VendorTypeDropDown, vendorType);
		Utilitymethods.enterText(GSTINnofield,gstinNumber);
		Utilitymethods.enterText(AddressField,address);
		Utilitymethods.elementclick(NewVendorSaveButton);
		boolean alreadyExistToastStatus=Utilitymethods.isElementDisplayed(VendorAlreadyExistToast);
		Utilitymethods.checkColor(VendorAlreadyExistToastDiv,"#bd362f","Vendor Already exist Toast");
		Utilitymethods.elementclick(ToastCloser);
		return alreadyExistToastStatus;
		
	}
	
	public boolean addVendorWithoutData() throws Exception
	{
		Utilitymethods.elementclick(AddVendorButton);
		Utilitymethods.waitForElementDisplayed(NewVendorHeader);
		return NewVendorSaveButton.isEnabled();
	}
	
	public boolean searchVendor(String name) throws Exception
	{
		Utilitymethods.enterText(SearchTextBox, name);
		Utilitymethods.DelayBy(2);
		return Utilitymethods.isElementDisplayed("//td[contains(text(),'"+name+"')]");
		
	}
	
	public boolean verifyVendorCreditDebitDialog(String vendorName, String GSTINnumber) throws Exception
	{
		Utilitymethods.elementclick("//td[text()='"+GSTINnumber+"']/preceding-sibling::td/a");
		Utilitymethods.waitForElementDisplayed(VendorDeditCreditHeader);
		Utilitymethods.isElementDisplayed("//b[text()='"+vendorName+"']");
		Utilitymethods.isElementDisplayed(CreditDebitGridHeader);
		return true;
	}
	
	
	
	
}
