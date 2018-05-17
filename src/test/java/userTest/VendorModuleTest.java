package userTest;


import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLib.AppLogger;
import genericLib.DataUtil;
import pageObjectRepository.VendorPage;
import pageObjectRepository.CommonPage;

public class VendorModuleTest extends BaseTest{
	
	
	
	@Test(enabled=false)
	public void A_Vendor_1() throws Exception
	{
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertTrue(vendor.vendorPageVerification());
			
	}

	@DataProvider
	public Object[][] A_Vendor_2Testdata(){
	return DataUtil.getData("A_Vendor_2","Vendor", xls);		
	}
	@Test(enabled=false,dataProvider="A_Vendor_2Testdata")
	public void A_Vendor_2(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_2 test skipped");
				throw new SkipException("Skipping the Test");
			}
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertTrue(vendor.addVendor(data.get("Name"),data.get("Email"),data.get("Mobile"),data.get("VendorType"),data.get("GSTIN Number"),data.get("Address")));
		
	}
	@DataProvider
	public Object[][] A_Vendor_3Testdata(){
	return DataUtil.getData("A_Vendor_3","Vendor", xls);		
	}
	@Test(enabled=false,dataProvider="A_Vendor_3Testdata")
	public void A_Vendor_3(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_3 test skipped");
				throw new SkipException("Skipping the Test");
			}
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertTrue(vendor.editVendor(data.get("ExistingVendorName"),data.get("Name"),data.get("Email"),data.get("Mobile"),data.get("VendorType"),data.get("GSTIN Number"),data.get("Address")));
		
	}
	@DataProvider
	public Object[][] A_Vendor_4Testdata(){
	return DataUtil.getData("A_Vendor_4","Vendor", xls);		
	}
	@Test(enabled=false,dataProvider="A_Vendor_4Testdata")
	public void A_Vendor_4(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_4 test skipped");
				throw new SkipException("Skipping the Test");
			}
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertFalse(vendor.deleteVendor(data.get("ExistingVendorName")));		
	}
	
	@DataProvider
	public Object[][] A_Vendor_5Testdata(){
	return DataUtil.getData("A_Vendor_5","Vendor", xls);		
	}
	@Test(enabled=false,dataProvider="A_Vendor_5Testdata")
	public void A_Vendor_5(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_5 test skipped");
				throw new SkipException("Skipping the Test");
			}
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertTrue(vendor.addDuplicateVendor(data.get("Name"),data.get("Email"),data.get("Mobile"),data.get("VendorType"),data.get("GSTIN Number"),data.get("Address")));
			Assert.assertFalse(vendor.deleteVendor(data.get("Name")));		
	}
	@DataProvider
	public Object[][] A_Vendor_6Testdata(){
	return DataUtil.getData("A_Vendor_6","Vendor", xls);		
	}
	@Test(enabled=false,dataProvider="A_Vendor_6Testdata")
	public void A_Vendor_6(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_6 test skipped");
				throw new SkipException("Skipping the Test");
			}
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertTrue(vendor.addVendor(data.get("Name"),data.get("Email"),data.get("Mobile"),data.get("VendorType"),data.get("GSTIN Number"),data.get("Address")));
			Assert.assertTrue(vendor.CancelOndeleteVendor(data.get("Name")));
			Assert.assertFalse(vendor.deleteVendor(data.get("Name")));		
	}
	@DataProvider
	public Object[][] A_Vendor_7Testdata(){
	return DataUtil.getData("A_Vendor_7","Vendor", xls);		
	}
	@Test(enabled=false,dataProvider="A_Vendor_7Testdata")
	public void A_Vendor_7(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_7 test skipped");
				throw new SkipException("Skipping the Test");
			}
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertTrue(vendor.addVendor(data.get("Name"),data.get("Email"),data.get("Mobile"),data.get("VendorType"),data.get("GSTIN Number"),data.get("Address")));
			Assert.assertTrue(vendor.editVendorWithoutUpdated(data.get("Name"),data.get("Email"),data.get("Mobile"),data.get("VendorType"),data.get("GSTIN Number"),data.get("Address")));
			Assert.assertFalse(vendor.deleteVendor(data.get("Name")));		
	}
	
	@Test(enabled=false)
	public void A_Vendor_8() throws Exception
	{
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
		common.goToVendorPage();
		Assert.assertFalse(vendor.addVendorWithoutData());
		
	}

	@DataProvider
	public Object[][] A_Vendor_9Testdata(){
	return DataUtil.getData("A_Vendor_9","Vendor", xls);		
	}
	@Test(enabled=false,dataProvider="A_Vendor_9Testdata")
	public void A_Vendor_9(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_9 test skipped");
				throw new SkipException("Skipping the Test");
			}
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertTrue(vendor.addVendor(data.get("Name"),data.get("Email"),data.get("Mobile"),data.get("VendorType"),data.get("GSTIN Number"),data.get("Address")));
			Assert.assertTrue(vendor.searchVendor(data.get("Name")));
			Assert.assertFalse(vendor.deleteVendor(data.get("Name")));		
	}
	@DataProvider
	public Object[][] A_Vendor_10Testdata(){
	return DataUtil.getData("A_Vendor_10","Vendor", xls);		
	}
	@Test(enabled=false,dataProvider="A_Vendor_10Testdata")
	public void A_Vendor_10(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_10 test skipped");
				throw new SkipException("Skipping the Test");
			}
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertFalse(vendor.searchVendor(data.get("Name")));
				
	}
	@DataProvider
	public Object[][] A_Vendor_11Testdata(){
	return DataUtil.getData("A_Vendor_11","Vendor", xls);		
	}
	@Test(dataProvider="A_Vendor_11Testdata")
	public void A_Vendor_11(Hashtable<String,String>data) throws Exception
	{
		if(data.get("RunMode").equals("N"))
			{
				AppLogger.logger.info("A_Vendor_11 test skipped");
				throw new SkipException("Skipping the Test");
			}
		CommonPage common=new CommonPage();
		VendorPage vendor=new VendorPage();
			common.goToVendorPage();
			Assert.assertTrue(vendor.addVendor(data.get("Name"),data.get("Email"),data.get("Mobile"),data.get("VendorType"),data.get("GSTIN Number"),data.get("Address")));
				
	}
}
