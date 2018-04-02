package userTest;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLib.AppLogger;
import genericLib.DataUtil;
import pageObjectRepository.VendorPage;
import pageObjectRepository.CategoryPage;
import pageObjectRepository.CommonPage;

public class VendorModuleTest extends BaseTest {
	@Test(enabled=false)
	public void A_Vendor_1() throws Exception
	{
			CommonPage common=new CommonPage();
			common.clickVendorSpan();
			VendorPage vendor=new VendorPage();
			try {
				Assert.assertTrue(vendor.vendorPageVerification());
			}
			catch(Exception ex)
			{
				Assert.assertTrue(false);
			}
			
	}
	
	@DataProvider
	public Object[][] A_Vendor_2Testdata(){
	return DataUtil.getData("A_Vendor_2","Vendor", xls);		
	}
	@Test(dataProvider="A_Vendor_2Testdata")
	public void A_Vendor_2(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_2 test skipped");
				throw new SkipException("Skipping the Test");
			}
			CommonPage common=new CommonPage();
			common.clickVendorSpan();
			VendorPage vendor=new VendorPage();
			vendor.addVendor(data.get("Name"),data.get("Email"),data.get("Mobile"),data.get("VendorType"),data.get("GSTIN Number"),data.get("Address"));
		
	}
	
	

}
