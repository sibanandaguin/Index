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
	
	@Test(enabled=false)
	public void A_Catagory_1() throws Exception
	{
			CommonPage common=new CommonPage();
			common.clickCategorySpan();
			CategoryPage category=new CategoryPage();
			Assert.assertTrue(category.CategoryPageAllElementVerification());
	}
	
	@DataProvider
	public Object[][] A_Catagory_2Testdata(){
	return DataUtil.getData("A_Catagory_2","Category", xls);		
	}
	@Test(enabled=false,dataProvider="A_Catagory_2Testdata")
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
			Assert.assertTrue(category.NewCategoryDialogAllElementVerification(data.get("Categoryname")));
	}
	@DataProvider
	public Object[][] A_Catagory_3Testdata(){
	return DataUtil.getData("A_Catagory_3","Category", xls);		
	}
	@Test(enabled=false,dataProvider="A_Catagory_3Testdata")
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
		Assert.assertTrue(category.AddcategoryFeature(data.get("Categoryname")));
		Assert.assertFalse(category.DeleteCategoryfeature(data.get("Categoryname")));
	}

	@DataProvider
	public Object[][] A_Catagory_4Testdata(){
	return DataUtil.getData("A_Catagory_4","Category", xls);		
	}
	@Test(enabled=false,dataProvider="A_Catagory_4Testdata")
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
		Assert.assertTrue(category.AddcategoryFeature(data.get("EditCategoryname")));
		Assert.assertTrue(category.EditCategoryfeature(data.get("EditCategoryname"),data.get("Categoryname")));
		Assert.assertFalse(category.DeleteCategoryfeature(data.get("Categoryname")));
	}
	@DataProvider
	public Object[][] A_Catagory_5Testdata()
	{
		return DataUtil.getData("A_Catagory_5","Category", xls);
	}
	@Test(enabled=false,dataProvider="A_Catagory_5Testdata")
		public void A_Catagory_5(Hashtable<String,String>data) throws Exception
		{
			if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Catagory_5 test skipped");
				throw new SkipException("Skipping the Test");
			}
			CommonPage common=new CommonPage();
			common.clickCategorySpan();
			CategoryPage category=new CategoryPage();
			Assert.assertTrue(category.AddcategoryFeature(data.get("Categoryname")));
			Assert.assertFalse(category.CancelClickOnDeleteCategoryDilogueBox(data.get("Categoryname")));
		}
	@DataProvider
	public Object[][] A_Category_6Testdata()
	{
		return DataUtil.getData("A_Catagory_6", "Category", xls);
	}
	@Test(enabled=false,dataProvider="A_Category_6Testdata")
	public void A_Categogry_6(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
		{
			AppLogger.logger.info("A_Category_6 test skipped");
			throw new SkipException("Skipping the Test");
		}
		CommonPage common=new CommonPage();
		common.clickCategorySpan();
		CategoryPage category=new CategoryPage();
		Assert.assertTrue(category.AddcategoryFeature(data.get("Categoryname")));
		Assert.assertTrue(category.SearchCategory(data.get("Categoryname")));
	}
	
	@Test(enabled=false)
	public void A_Catagory_7() throws Exception
	{
		CommonPage common=new CommonPage();
		common.clickCategorySpan();
		CategoryPage category=new CategoryPage();
		Assert.assertTrue(category.VerifyAddItemFeature());
	}
	@DataProvider
	public Object[][] A_Category_8Testdata()
	{
		return DataUtil.getData("A_Catagory_8", "Category", xls);
	}
	@Test(enabled=false,dataProvider="A_Category_8Testdata")
	
		public void A_Category_8(Hashtable<String,String>data) throws Exception
		{
			if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Category_8 test skipped");
				throw new SkipException("Skipping the Test");
			}
			CommonPage common=new CommonPage();
			common.clickCategorySpan();
			CategoryPage category=new CategoryPage();
			Assert.assertTrue(category.AddcategoryFeature(data.get("Categoryname")));
			Assert.assertTrue(category.VerifycategoryNewItempage(data.get("Categoryname")));
			Assert.assertFalse(category.DeleteCategoryfeature(data.get("Categoryname")));
		}
	@DataProvider
	public Object[][] A_Category_9Testdatta()
	{
		return DataUtil.getData("A_Catagory_9","Category",xls);
	}
	@Test(enabled=false,dataProvider="A_Category_9Testdatta")
	public void A_Category_9(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
		{
			AppLogger.logger.info("A_Category_9 is skipped");
			throw new SkipException("Skipping the Test");
		}
		CommonPage cmn=new CommonPage();
		cmn.clickCategorySpan();
		CategoryPage category=new CategoryPage();
		Assert.assertTrue(category.AddcategoryFeature(data.get("Categoryname")));
		Assert.assertTrue(category.AddItem(data.get("Itemname"),data.get("Categoryname"),data.get("HSNCode"),data.get("LowStockQuantity"),data.get("Unit"),data.get("MRP")));
		Assert.assertFalse(category.DeleteCategoryfeature(data.get("Categoryname")));
	}
	@DataProvider
	public Object[][] A_Category_10Testdatta()
	{
		return DataUtil.getData("A_Catagory_10", "Category",xls);
	}
	@Test(dataProvider="A_Category_10Testdatta")
	public void A_Category_10(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
		{
			AppLogger.logger.info("A_Category_9 is skipped");
			throw new SkipException("Skipping the Test");
		}
		CommonPage cmn=new CommonPage();
		cmn.clickCategorySpan();
		CategoryPage category=new CategoryPage();
		Assert.assertTrue(category.AddcategoryFeature(data.get("Categoryname")));
		Assert.assertTrue(category.AddItem(data.get("Itemname"),data.get("Categoryname"),data.get("HSNCode"),data.get("LowStockQuantity"),data.get("Unit"),data.get("MRP")));
		Assert.assertTrue(category.VerifyItemList(data.get("Categoryname"),data.get("Itemname"),data.get("Categoryname"),data.get("HSNCode"),data.get("LowStockQuantity"),data.get("Unit"),data.get("MRP")));
		Assert.assertFalse(category.DeleteCategoryfeature(data.get("Categoryname")));
	}
	
	}
	

	




