package pageObjectRepository;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.AppLogger;
import genericLib.Utilitymethods;
import userTest.BaseTest;
import userTest.CategoryModuleTest;
public class CategoryPage extends CategoryModuleTest{
	
	
	//Constructor
	public CategoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[@ng-click='catCtrl.addCategory()']")
	private WebElement AddCategoryButton;
	
	@FindBy(xpath="//input[@placeholder='name']")
	private WebElement CategoryNameField;
	
	@FindBy(xpath="//button[@ng-click='catCtrl.addItem()']")
	private WebElement AddItemButton;
	
	@FindBy(xpath="//b[text()='New Item']")
	private WebElement NewItemdialogbox;
	
	@FindBy(xpath="//input[@placeholder='item name']")
	private WebElement ItemNameField;
	
	@FindBy(xpath="//input[@placeholder='search Category']")
	private WebElement SearchCategoryField;
	
	
	@FindBy(xpath="//input[@ng-model='aic.addItem.hsnCode']")
	private WebElement HSNcodeField;
	
	@FindBy(xpath="//select[@ng-model='aic.addItem.gstRate']")
	private WebElement GstField;
	
	@FindBy(xpath="//input[@ng-model='aic.addItem.lowStock']")
	private WebElement LowStockQuantityField;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement NewCategoryAddButton;
	
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement SearchButtonCategoryPage;
	
	@FindBy(xpath="//div[text()='category added']")
	private WebElement AddCategorySuccessBanner;
	
	@FindBy(xpath=("//button[text()='Update']"))
	private WebElement CategoryEditdialogUpdate;
	
	@FindBy(xpath="//div[text()='category updated']")
	private WebElement UpdateSuccessBanner;
	
	@FindBy(xpath="//div[@class='toast ng-scope toast-success']")
	private WebElement SuccessBannerColour; 
	
	@FindBy(xpath="//b[text()='( Deleting a category will delete the item from stock.Please be careful before deleting a category )']")
	private WebElement InfotextforDeleteCategory;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement SearchCategoryBox;
	
	@FindBy(xpath="//b[text()='Confirm']")
	private WebElement DeleteConfirmHeader;
	
	@FindBy(xpath="//b[text()='Do you want to Delete ?']")
	private WebElement Deletedialogboxmessage;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement CancelButton;
	
	@FindBy(xpath="//button[text()='Ok']")
	private WebElement OKButton;
	
	@FindBy(xpath="//div[text()='Category Deleted']")
	private WebElement DeleteSuccessBanner;
	
	@FindBy(xpath="//tr[@class='row warning']//th[text()='Category']")
	private WebElement CategoryColumn;
	
	@FindBy(xpath="//tr[@class='row warning']//th[text()='Items']")
	private WebElement ItemsColumn;
	
	@FindBy(xpath="//tr[@class='row warning']//th[text()='Action']")
	private WebElement ActionsColumn;
	
	@FindBy(xpath="//span[contains(text(),'CATEGORY')]")
	private WebElement CATEGORYPageMarker;
	
	@FindBy(xpath="//b[text()='New category']")
	private WebElement NewCategoryHeader;
	
	@FindBy(xpath="//b[text()='New category']/following-sibling::a")
	private WebElement NewCategoryDialogboxCloser;
	
	@FindBy(xpath="//label[text()='Category Name']")
	private WebElement CategoryNameLabel;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement AddButtonInNewCategoryDialog;
	
	
	
	
	
	public void CategoryPageAllElementVerification()
	{
		Utilitymethods.elementIsDisplayed(AddCategoryButton,"Add category button");
		Utilitymethods.elementIsDisplayed(AddItemButton, "Add Item button");
		Utilitymethods.elementIsDisplayed(SearchCategoryBox,"Search Category Box");
		Utilitymethods.elementIsDisplayed(CategoryColumn,"Category Column");
		Utilitymethods.elementIsDisplayed(CATEGORYPageMarker,"CATEGORY PageMarker");
		
	}
	public void NewCategoryDialogAllElementVerification(String categoryName)
	{
		Utilitymethods.elementclick(AddCategoryButton);
		Utilitymethods.isElementVisible(NewCategoryHeader);
		Utilitymethods.elementIsDisplayed(NewCategoryDialogboxCloser,"New CategoryDialogbox Closer");
		Utilitymethods.elementIsDisplayed(CategoryNameLabel,"Category Name Label");
		Utilitymethods.elementIsDisplayed(CategoryNameField,"Category Name Field");
		if(AddButtonInNewCategoryDialog.isDisplayed())
		{
			AppLogger.logger.info("Add button is displayed in New CategoryWindow.");
			if(AddButtonInNewCategoryDialog.isEnabled())
			{
				AppLogger.logger.info("Add button is enabled when Category field is empty.");
			}
		}else 
		{
			AppLogger.logger.info("Add button is disabled when Category field is empty.");
			Utilitymethods.enterText(CategoryNameField, categoryName);
			Utilitymethods.elementIsDisplayed(AddButtonInNewCategoryDialog,"Add Button In NewCategoryDialog when Category name is given");
		}
		Utilitymethods.elementclick(NewCategoryDialogboxCloser);

	}
	public void AddcategoryFeature(String categoryName)
	{
		Utilitymethods.elementclick(AddCategoryButton);
		Utilitymethods.enterText(CategoryNameField,categoryName);
		Utilitymethods.elementclick(NewCategoryAddButton);
		Utilitymethods.elementIsDisplayed(AddCategorySuccessBanner,"AddCategory SuccessBanner");
		Utilitymethods.checkColor(SuccessBannerColour,"#51a351","Addcategory success banner");
		//return AddCategorySuccessBanner.getText();
		
	}
	public void  EditCategoryfeature(String EditCategoryname,String categoryName)
	{
		driver.findElement(By.xpath("//td[text()='"+EditCategoryname+"']/following-sibling::td/a/i[@class='fa fa-edit text-success']")).click();
		Utilitymethods.elementIsDisplayed(CategoryEditdialogUpdate,"Category Edit dialog Update");
//		CategoryNameField.clear();
		Utilitymethods.enterText(CategoryNameField,categoryName);
		CategoryEditdialogUpdate.click();
		Utilitymethods.elementIsDisplayed(UpdateSuccessBanner,"Update Success Banner");
		Utilitymethods.checkColor(SuccessBannerColour,"#51a351", "Update Banner");
	}
	public void DeleteCategoryfeature(String categoryName)
	{
		driver.findElement(By.xpath("//td[text()='"+categoryName+"']/following-sibling::td/a/i[@class='fa fa-trash text-danger']")).click();
		Utilitymethods.elementIsDisplayed(DeleteConfirmHeader,"Delete popup");
		Utilitymethods.elementIsDisplayed(Deletedialogboxmessage,"Delete dialogbox message");
		Utilitymethods.elementIsEnabled(CancelButton,"Cancel Button");
		Utilitymethods.elementIsEnabled(OKButton,"OK Button");
		Utilitymethods.elementclick(CancelButton);
		AppLogger.logger.info("cancel clicked");
		Utilitymethods.elementIsDisplayed(CATEGORYPageMarker,"CATEGORY Page Marker");
		if(driver.findElement(By.xpath("//td[text()='"+categoryName+"']")).isDisplayed())
		{
			AppLogger.logger.info("category not deleted.");
		}
		else
		{
			AppLogger.logger.info("category deleted.");
		}
		driver.findElement(By.xpath("//td[text()='"+categoryName+"']/following-sibling::td/a/i[@class='fa fa-trash text-danger']")).click();
		OKButton.click();
		AppLogger.logger.info("now category deleted");
		Utilitymethods.elementIsDisplayed(DeleteSuccessBanner,"Delete Success Banner");
		Utilitymethods.checkColor(SuccessBannerColour,"#51a351", "Delete Banner");
	}
	public void SearchCategory(String categoryname) throws Exception
	{
		Utilitymethods.elementclick(AddCategoryButton);
		Utilitymethods.enterText(CategoryNameField,categoryname);
		Utilitymethods.elementclick(NewCategoryAddButton);
		Utilitymethods.enterText(SearchButtonCategoryPage,categoryname);
		if(driver.findElement(By.xpath("//td[text()='"+categoryname+"']")).isDisplayed())
		{
			AppLogger.logger.info("Category dispalyed Successfully");
		}
		else
		{
			AppLogger.logger.info("Category not dispalyed in category table");
		}
		driver.findElement(By.xpath("//td[text()='"+categoryname+"']/following-sibling::td/a/i[@class='fa fa-trash text-danger']")).click();
		Utilitymethods.elementclick(OKButton);
		Utilitymethods.DelayBy(2);
		Utilitymethods.enterText(SearchButtonCategoryPage,categoryname);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		if(driver.findElements(By.xpath("//td[text()='"+categoryname+"']")).size()>0)
			AppLogger.logger.info("Category Still exist");
		else
		{
			AppLogger.logger.info("Category deleted successfully");
		}
	}
	public void VerifyAddItemFeature()
	{
		Utilitymethods.elementclick(AddItemButton);
		Utilitymethods.elementIsDisplayed(NewItemdialogbox,"NewItem dialog box");
		Utilitymethods.elementIsDisplayed(ItemNameField,"Item Name Field");
		Utilitymethods.elementIsDisplayed(SearchCategoryField,"Search Category Field");
		Utilitymethods.elementIsDisplayed(HSNcodeField,"HSNcode Field");
		Utilitymethods.elementIsDisplayed(GstField,"Gst Field");
		Utilitymethods.elementIsDisplayed(LowStockQuantityField,"LowStockQuantity Field");
		
	}
	public void VerifycategoryNewItempage(String categoryName)
	{
		Utilitymethods.elementclick(AddCategoryButton);
		Utilitymethods.enterText(CategoryNameField,categoryName);
		Utilitymethods.elementclick(NewCategoryAddButton);
		Utilitymethods.elementclick(AddItemButton);
		Utilitymethods.enterText(SearchCategoryField,categoryName);
		Utilitymethods.elementIsDisplayed(driver.findElement(By.xpath("//strong[text()='"+categoryName+"']")),"Existing Category in Item page");
		
	}
	}
	
	
	
	


