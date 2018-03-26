package pageObjectRepository;

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
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement NewCategoryAddButton;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement SearchButtonCategoryPage;
	
	@FindBy(xpath="//div[text()='category added']")
	private WebElement AddCategorySuccessBanner;
	
	@FindBy(xpath=("//button[text()='Update']"))
	private WebElement CategoryEditdialogUpdate;
	
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
		if(AddCategoryButton.isDisplayed()) 
		{
			AppLogger.logger.info("Add Category button is displayed.");
		}else {AppLogger.logger.info("Add Category button is not displayed.");}
		if(AddItemButton.isDisplayed()) 
		{
			AppLogger.logger.info("Add Item button is displayed.");
		}else {AppLogger.logger.info("Add Item button is not displayed.");}
		if(SearchCategoryBox.isDisplayed()) 
		{
			AppLogger.logger.info("Search Category box is displayed.");
		}else {AppLogger.logger.info("Search Category box is not displayed.");}
		if(CategoryColumn.isDisplayed() && ItemsColumn.isDisplayed() && ActionsColumn.isDisplayed()) 
		{
			AppLogger.logger.info("Category grid is displayed.");
		}else {AppLogger.logger.info("Category grid is not displayed.");}
		if(CATEGORYPageMarker.isDisplayed()) 
		{
			AppLogger.logger.info("Category page marker grid is displayed.");
		}else {AppLogger.logger.info("Category page marker grid is not displayed.");}
		
	}
	public void NewCategoryDialogAllElementVerification(String categoryName)
	{
		Utilitymethods.elementclick(AddCategoryButton);
		Utilitymethods.isElementVisible(NewCategoryHeader);
		if(NewCategoryDialogboxCloser.isDisplayed())
		{
			AppLogger.logger.info("New Category closed button is displayed.");
		}else {AppLogger.logger.info("New Category closed button is not displayed.");}
		
		if(CategoryNameLabel.isDisplayed())
		{
			AppLogger.logger.info("Category name label is displayed.");
		}else {AppLogger.logger.info("Category name label is not displayed.");}
		if(CategoryNameField.isDisplayed())
		{
			AppLogger.logger.info("Category name field is displayed.");
		}else {AppLogger.logger.info("Category name filed is not displayed.");}
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
			if(AddButtonInNewCategoryDialog.isEnabled())
			{
				AppLogger.logger.info("Add button is enabled when Category name is given .");
			}else {AppLogger.logger.info("Add button is still disabled when Category name is given .");}
		}
		Utilitymethods.elementclick(NewCategoryDialogboxCloser);

	}
	public String AddcategoryFeature(String categoryName)
	{
		Utilitymethods.elementclick(AddCategoryButton);
		Utilitymethods.enterText(CategoryNameField,categoryName);
		Utilitymethods.elementclick(NewCategoryAddButton);
		return AddCategorySuccessBanner.getText();
		
	}
	public void  EditCategoryfeature(String EditCategoryname,String categoryName)
	{
		driver.findElement(By.xpath("//td[text()='"+EditCategoryname+"']/following-sibling::td/a/i[@class='fa fa-edit text-success']")).click();
		if(CategoryEditdialogUpdate.isDisplayed())
		{
			AppLogger.logger.info("Category edit field is displayed.");
		}else {AppLogger.logger.info("Category edit filed is not displayed.");
		}
		CategoryNameField.clear();
		Utilitymethods.enterText(CategoryNameField,categoryName);
		CategoryEditdialogUpdate.click();
		
	}
	public void DeleteCategoryfeature(String categoryName)
	{
		driver.findElement(By.xpath("//td[text()='"+categoryName+"']/following-sibling::td/a/i[@class='fa fa-trash text-danger']")).click();
		if(DeleteConfirmHeader.isDisplayed())
		{
			AppLogger.logger.info("Delete popup displayed");
		}
		else
		{
			AppLogger.logger.info("Delete popup not displayed");
		}
		if(Deletedialogboxmessage.isDisplayed())
		{
			AppLogger.logger.info("Delete dialogbox message displayed");
		}
		else
		{
			AppLogger.logger.info("Delete dialogbox message not displayed");
		}
		
		if(CancelButton.isEnabled())
		{
			AppLogger.logger.info("cancel button enabled");
		}
		else
		{
			AppLogger.logger.info("cancel button not enabled");
		}

		if(OKButton.isEnabled())
		{
			AppLogger.logger.info("OK button enabled");
		}
		else
		{
			AppLogger.logger.info("OK button not enabled");
		}
		Utilitymethods.elementclick(CancelButton);
		AppLogger.logger.info("cancel clicked");
		if(CATEGORYPageMarker.isDisplayed())
		{
			AppLogger.logger.info("User in category page");
		}
		else
		{
			AppLogger.logger.info("User not in category page");
		}
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
		if(DeleteSuccessBanner.isDisplayed())
		{
			AppLogger.logger.info("Delete success banner displayed");
		}
		else
		{
			AppLogger.logger.info("Delete success banner not displayed");
		}
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
		Boolean value=driver.findElement(By.xpath("//td[text()='Search_Category']")).isDisplayed();
		System.out.println(value);
//		Utilitymethods.enterText(SearchButtonCategoryPage,categoryname);
//		Actions act=new Actions(driver);
//		act.sendKeys(Keys.ENTER).perform();
//		if(driver.findElement(By.xpath("//td[text()='"+categoryname+"']")).isDisplayed())
//		{
//			AppLogger.logger.info("Category Still exist");
//		}
//		else
//		{
//			AppLogger.logger.info("Category deleted successfully");
//		}
	}
	}
	
	
	
	


