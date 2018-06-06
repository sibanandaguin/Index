package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import genericLib.AppLogger;
import genericLib.Utilitymethods;
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
	
	@FindBy(xpath="//input[@placeholder='unit']")
	private WebElement Unit;
	
	@FindBy(xpath="//label[contains(text(),'MRP')]/following-sibling::div/input")
	private WebElement Mrp;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	private WebElement NewItempageCloseIcon;
	
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement NewItemAdd;
	
	@FindBy(xpath="//div[text()='Item added Successfully']")
	private WebElement AdditemSuccesstoostmessage;
	
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
	
	@FindBy(xpath="//b[contains(text(),'Item')]/following-sibling::a/i")
	private WebElement ClosebuttonInItemPage;
	
	public boolean CategoryPageAllElementVerification()
	{
		Utilitymethods.isElementDisplayed(AddCategoryButton);
		Utilitymethods.isElementDisplayed(AddItemButton);
		Utilitymethods.isElementDisplayed(SearchCategoryBox);
		Utilitymethods.isElementDisplayed(CategoryColumn);
		Utilitymethods.isElementDisplayed(CATEGORYPageMarker);
		return true;
	}
	public boolean NewCategoryDialogAllElementVerification(String categoryName) throws Exception
	{
		Utilitymethods.elementclick(AddCategoryButton);
		Utilitymethods.waitForElementDisplayed(NewCategoryHeader);
		Utilitymethods.isElementDisplayed(NewCategoryDialogboxCloser);
		Utilitymethods.isElementDisplayed(CategoryNameLabel);
		Utilitymethods.isElementDisplayed(CategoryNameField);
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
		}
		Utilitymethods.enterText(CategoryNameField, categoryName);
		boolean status=AddButtonInNewCategoryDialog.isEnabled();
		Utilitymethods.elementclick(NewCategoryDialogboxCloser);
        return status;
	}
	public boolean AddcategoryFeature(String categoryName)
	{
		Utilitymethods.elementclick(AddCategoryButton);
		Utilitymethods.enterText(CategoryNameField,categoryName);
		Utilitymethods.elementclick(NewCategoryAddButton);
		boolean status=Utilitymethods.isElementDisplayed(AddCategorySuccessBanner);
		Utilitymethods.checkColor(SuccessBannerColour,"#51a351","Addcategory success banner");
		return status;
	}
	public boolean  EditCategoryfeature(String EditCategoryname,String categoryName)
	{
		Utilitymethods.elementclick(driver.findElement(By.xpath("//td[text()='"+EditCategoryname+"']/following-sibling::td/a/i[@class='fa fa-edit text-success']")));
		Utilitymethods.isElementDisplayed(CategoryEditdialogUpdate);
		Utilitymethods.enterText(CategoryNameField,categoryName);
		CategoryEditdialogUpdate.click();
		boolean status=Utilitymethods.isElementDisplayed(UpdateSuccessBanner);
		Utilitymethods.checkColor(SuccessBannerColour,"#51a351", "Update Banner");
		return status;
	}
	public boolean CancelClickOnDeleteCategoryDilogueBox(String categoryName)
	{
		Utilitymethods.elementclick(driver.findElement(By.xpath("//td[text()='"+categoryName+"']/following-sibling::td/a/i[@class='fa fa-trash text-danger']")));
		Utilitymethods.isElementDisplayed(DeleteConfirmHeader);
		Utilitymethods.isElementDisplayed(Deletedialogboxmessage);
		Utilitymethods.elementclick(CancelButton);
		AppLogger.logger.info("cancel clicked");
		Utilitymethods.isElementDisplayed(CATEGORYPageMarker);
		if(driver.findElement(By.xpath("//td[text()='"+categoryName+"']")).isDisplayed())
		{
			AppLogger.logger.info("category not deleted.");
		}
		else
		{
			AppLogger.logger.info("category deleted.");
		}
		WebElement categorydelete=driver.findElement(By.xpath("//td[text()='"+categoryName+"']/following-sibling::td/a/i[@class='fa fa-trash text-danger']"));
		Utilitymethods.elementclick(categorydelete);
		Utilitymethods.waitForClickable(OKButton);
		Utilitymethods.elementclick(OKButton);
		AppLogger.logger.info("now category deleted");
		Utilitymethods.isElementDisplayed(DeleteSuccessBanner);
		Utilitymethods.checkColor(SuccessBannerColour,"#51a351", "Delete Banner");
		return Utilitymethods.isElementDisplayed("//td[text()='"+categoryName+"']");
	}
	public boolean DeleteCategoryfeature(String categoryName)
	{
		Utilitymethods.elementclick(driver.findElement(By.xpath("//td[text()='"+categoryName+"']/following-sibling::td/a/i[@class='fa fa-trash text-danger']")));
		Utilitymethods.isElementDisplayed(DeleteConfirmHeader);
		Utilitymethods.isElementDisplayed(Deletedialogboxmessage);
		Utilitymethods.isElementDisplayed(CATEGORYPageMarker);
		Utilitymethods.elementclick(OKButton);
		AppLogger.logger.info("now category deleted");
		Utilitymethods.isElementDisplayed(DeleteSuccessBanner);
		Utilitymethods.checkColor(SuccessBannerColour,"#51a351", "Delete Banner");
		return Utilitymethods.isElementDisplayed("//td[text()='"+categoryName+"']");
	}
	public boolean SearchCategory(String categoryname) throws Exception
	{
		Utilitymethods.enterText(SearchButtonCategoryPage,categoryname);
		if(driver.findElement(By.xpath("//td[text()='"+categoryname+"']")).isDisplayed())
		{
			AppLogger.logger.info("Category dispalyed Successfully");
		}
		else
		{
			AppLogger.logger.info("Category not dispalyed in category table");
		}
		WebElement category=driver.findElement(By.xpath("//td[text()='"+categoryname+"']/following-sibling::td/a/i[@class='fa fa-trash text-danger']"));
		Utilitymethods.elementclick(category);
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
		return true;
	}
	public boolean VerifyAddItemFeature()
	{
		Utilitymethods.elementclick(AddItemButton);
		Utilitymethods.isElementDisplayed(NewItemdialogbox);
		Utilitymethods.isElementDisplayed(ItemNameField);
		Utilitymethods.isElementDisplayed(SearchCategoryField);
		Utilitymethods.isElementDisplayed(HSNcodeField);
		Utilitymethods.isElementDisplayed(GstField);
		Utilitymethods.isElementDisplayed(LowStockQuantityField);
		Utilitymethods.isElementDisplayed(Unit);
		Utilitymethods.isElementDisplayed(Mrp);
		Utilitymethods.elementclick(NewItempageCloseIcon); 
		return true;
		
	}
	public boolean VerifycategoryNewItempage(String categoryName) throws Exception
	{
		Utilitymethods.elementclick(AddItemButton);
		Utilitymethods.enterText(SearchCategoryField,categoryName);
		Utilitymethods.waitForElementDisplayed("//strong[text()='"+categoryName+"']");
	    Utilitymethods.isElementDisplayed("//strong[text()='"+categoryName+"']");
	    Utilitymethods.elementclick(NewItempageCloseIcon);
	    return true;
	}
	public boolean AddItem(String itemname,String category,String hsncode,String lowstockQuantity,String unit,String mrp)
	{
		Utilitymethods.isElementDisplayed(AddItemButton);
		Utilitymethods.elementclick(AddItemButton);
		Utilitymethods.isElementDisplayed(NewItemdialogbox);
		Utilitymethods.enterText(ItemNameField,itemname);
		Utilitymethods.enterText(SearchCategoryField,category);
		Utilitymethods.isElementDisplayed("//strong[text()='"+category+"']");
		WebElement NewItemcategory=driver.findElement(By.xpath("//a[@title='"+category+"']"));
		Utilitymethods.elementclick(NewItemcategory);
		Utilitymethods.enterText(HSNcodeField,hsncode);
		Utilitymethods.isElementDisplayed(GstField);
		Select sel=new Select(GstField);
		sel.selectByValue("3 %");
		Utilitymethods.enterText(LowStockQuantityField, lowstockQuantity);
		Utilitymethods.enterText(Unit, unit);
		Utilitymethods.enterText(Mrp, mrp);
		Utilitymethods.waitForClickable(NewItemAdd);
		Utilitymethods.elementclick(NewItemAdd);
		Utilitymethods.isElementDisplayed(AdditemSuccesstoostmessage);
		return Utilitymethods.isElementDisplayed(AdditemSuccesstoostmessage);
	}
	public boolean VerifyItemList(String Category,String itemname,String HSNCode,String GSTRate,String LowstockQuantity,String MRP,String Action)
	{
		WebElement itemlist=driver.findElement(By.xpath("//td[text()='"+Category+"']/following-sibling::td[1]/button/span[text()='Item List']"));
		Utilitymethods.waitForClickable(itemlist);
		Utilitymethods.elementclick(itemlist);
		if(Utilitymethods.isElementDisplayed("//b[contains(text(),'Item List')]/span[text()='"+Category+"']"));
		AppLogger.logger.info("Item displayed inside correct category");
		if(Utilitymethods.isElementDisplayed("//tr[th[text()='Name']]/following-sibling::tr/td[1]/span[text()='"+itemname+"']"));
		AppLogger.logger.info("Correct Item Name displayed ");
		if(Utilitymethods.isElementDisplayed("//tr[th[text()='HSN Code']]/following-sibling::tr/td[2]/span[text()='"+HSNCode+"']"));
		AppLogger.logger.info("Correct HSN code displayed ");
		if(Utilitymethods.isElementDisplayed("//tr[th[text()='GST Rate']]/following-sibling::tr/td[3]/span[text()='"+GSTRate+"']"));
		AppLogger.logger.info("Correct GST Rate displayed");
		if(Utilitymethods.isElementDisplayed("//tr[th[text()='Low stock Quantity']]/following-sibling::tr/td[4]/span[text()='"+LowstockQuantity+"']"));
		AppLogger.logger.info("Correct LowstockQuantity  displayed");
		if(Utilitymethods.isElementDisplayed("//tr[th[text()='MRP']]/following-sibling::tr/td[5]/span[text()='"+MRP+"']"));
		AppLogger.logger.info("Correct MRP  displayed");
		if(Utilitymethods.isElementDisplayed("//tr[th[text()='Action']]/following-sibling::tr/td[6]/span[text()='"+Action+"']"));
		AppLogger.logger.info("Correct Action displayed");
		Utilitymethods.elementclick(ClosebuttonInItemPage);
		return true;
	}
	}
	
	
	
	


