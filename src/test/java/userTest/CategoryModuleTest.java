package userTest;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLib.AppLogger;
import genericLib.DataUtil;
import pageObjectRepository.CategoryPage;
import pageObjectRepository.CommonPage;

public class CategoryModuleTest extends BaseTest{
	
	@Test
	public void A_Catagory_1() throws Exception
	{
			CommonPage common=new CommonPage();
			common.clickCategorySpan();
			CategoryPage category=new CategoryPage();
			category.CategoryPageAllElementVerification();	
	}
	
	@DataProvider
	public Object[][] A_Catagory_2Testdata(){
	return DataUtil.getData("A_Catagory_2","Category", xls);		
	}
	@Test(dataProvider="A_Catagory_2Testdata")
	public void A_Catagory_2(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Catagory_2 test skipped");
				throw new SkipException("Skipping the Test");
			}
			CommonPage common=new CommonPage();
			common.clickCategorySpan();
			CategoryPage category=new CategoryPage();
			category.NewCategoryDialogAllElementVerification(data.get("Categoryname"));
	}
	@DataProvider
	public Object[][] A_Catagory_3Testdata(){
	return DataUtil.getData("A_Catagory_3","Category", xls);		
	}
	@Test(dataProvider="A_Catagory_3Testdata")
	public void A_Catagory_3(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
		{
			AppLogger.logger.info("A_Catagory_3 test skipped");
			throw new SkipException("Skipping the Test");
		}
		CommonPage common=new CommonPage();
		common.clickCategorySpan();
		CategoryPage category=new CategoryPage();
		String actualmessage=category.AddcategoryFeature(data.get("Categoryname"));
		Assert.assertEquals(actualmessage,"category added");
	}
	@DataProvider
	public Object[][] A_Catagory_4Testdata(){
	return DataUtil.getData("A_Catagory_4","Category", xls);		
	}
	@Test(dataProvider="A_Catagory_4Testdata")
	public void A_Catagory_4(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
		{
			AppLogger.logger.info("A_Catagory_4 test skipped");
			throw new SkipException("Skipping the Test");
		}
		CommonPage common=new CommonPage();
		common.clickCategorySpan();
		CategoryPage category=new CategoryPage();
		category.EditCategoryfeature(data.get("EditCategoryname"),data.get("Categoryname"));
	}
	
	}


