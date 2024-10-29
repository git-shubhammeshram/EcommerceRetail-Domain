package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._1_LoginPage;
import Pages._2_InventoryPage;
import Pages._3_CartPage;
import Pages._4_CheckoutPage;
import Pages._5_CheckoutPageOverviewPage;
import Pages._7_LogoutPage;
import Utility.CaptureScreenShot;

public class _8_LogoutPageTestCase extends TestBase{
	
	_7_LogoutPage logout;
	
	@BeforeMethod
	public void init() throws InterruptedException, IOException {
		initialization();
		_1_LoginPage login = new _1_LoginPage();
		login.verifyUserLogin();
		
		_2_InventoryPage inventory = new _2_InventoryPage();
		inventory.varifyAddSixProductIntoCart();
		inventory.clickOnCart();
		
		_3_CartPage cart = new _3_CartPage();
		cart.verifyCheckoutButton();
		
		_4_CheckoutPage checkout = new _4_CheckoutPage();
		checkout.verfiyAddCheckOutDetailsTest();
		
		_5_CheckoutPageOverviewPage overview = new _5_CheckoutPageOverviewPage();
		overview.verifyClickFinishButton();
		
		logout = new _7_LogoutPage();
	}
	
	@Test
	public void verifyUserLogoutTest() {
		
		String expResult = "https://www.saucedemo.com/";
		 String actResult = logout.verifyUserLogout();
		 
		 Assert.assertEquals(expResult, actResult);
		 Reporter.log("After logging out URL is:- "+actResult);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws IOException {
		if(result.FAILURE == result.getStatus()) {
			CaptureScreenShot.getScreenShots(result.getTestName());
		}
		report.flush();
		driver.close();
	}
	
}
