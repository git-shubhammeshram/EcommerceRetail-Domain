package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._3_CartPage;
import Pages._4_CheckoutPage;
import Utility.CaptureScreenShot;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _4_CheckoutPageTestCase extends TestBase {
	
	_4_CheckoutPage checkout ;
	
	@BeforeMethod(alwaysRun = true)
	public void init() throws InterruptedException, IOException {
		initialization();
		_1_LoginPage login = new _1_LoginPage();
		login.verifyUserLogin();
		
		_2_InventoryPage inventory = new _2_InventoryPage();
		inventory.varifyAddSixProductIntoCart();
		inventory.clickOnCart();
		
		_3_CartPage cart = new _3_CartPage();
		cart.verifyCheckoutButton();
		
		checkout = new _4_CheckoutPage();
		
	}
	
	
	@Test(enabled = true,groups = {"Smoke"})
	public void verifyCheckOutPageURLTest() {
		String expResult = "https://www.saucedemo.com/checkout-step-one.html";
		String actResult = checkout.verifyCheckOutPageURL();
		
		Assert.assertEquals(actResult, expResult);
		Reporter.log("After the clicking on cart page the showing URL is:- "+actResult);
	}
	
	@Test(enabled = true,groups = {"Smoke"})
	public void verifyCheckOutPageTitleTest() {
		String expResult = "Swag Labs";
		String actResult = checkout.verifyCheckOutPageTitle();
		
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Checkout page showing Title is:- "+actResult);
		
	}
	
	@Test(groups = {"Smoke"})
	public void verfiyAddCheckOutDetailsTest() {
		String expResult = "https://www.saucedemo.com/checkout-step-two.html";
		String actResult = checkout.verfiyAddCheckOutDetailsTest();
		
		Assert.assertEquals(actResult, expResult);
		Reporter.log("After clicking on continue button next page URL is:- "+actResult);
		
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
