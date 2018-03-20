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
	public void A_1() throws Exception
	{
			CommonPage common=new CommonPage();
			common.clickCategorySpan();
			CategoryPage category=new CategoryPage();
			category.CategoryPageAllElementVerification();	
	}
	
	@DataProvider
	public Object[][] A_2Testdata(){
	return DataUtil.getData("A_2","TestData", xls);		
	}
	@Test(dataProvider="A_2Testdata")
	public void A_2(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_2 test skipped");
				throw new SkipException("Skipping the Test");
			}
			CommonPage common=new CommonPage();
			common.clickCategorySpan();
			CategoryPage category=new CategoryPage();
			category.NewCategoryDialogAllElementVerification(data.get("Categoryname"));
	}
	}


