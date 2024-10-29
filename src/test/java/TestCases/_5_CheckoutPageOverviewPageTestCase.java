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
import Pages._5_CheckoutPageOverviewPage;
import Utility.CaptureScreenShot;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _5_CheckoutPageOverviewPageTestCase extends TestBase {
	
 
	_5_CheckoutPageOverviewPage overview;
	
	
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
		
		_4_CheckoutPage checkout = new _4_CheckoutPage();
		checkout.verfiyAddCheckOutDetailsTest();
		
		overview = new _5_CheckoutPageOverviewPage();
		
	}
	
	@Test(enabled = true, groups = {"Smoke"})
	public void verifyOverviewPageTitleTextTest() {
		String expresult = "Checkout: Overview";
		String actResult = overview.verifyOverviewPageTitleText();
		
		Assert.assertEquals(actResult, expresult);
		Reporter.log("Overview page title shown in:-"+expresult);
	}
	
	
	@Test(enabled = true,groups = {"Smoke"})
	public void verifyQtyLableTextTest() {
		
		boolean actResult = overview.verifyQtyLableText();

        Assert.assertTrue(actResult);
		Reporter.log("Qty lable shown in webpage:- "+ true);
	}
	
	
	@Test(enabled = true,groups = {"Smoke"})
	public void verifyDescriptionLableTextTest() {
		
		boolean actResult = overview.verifyDescriptionLableText();

        Assert.assertTrue(actResult);
		Reporter.log("Description liable shown in webpage:- "+ true);
	}
	
	@Test(enabled = true,groups = {"Smoke"})
	public void verfiyPaymentLableTextTest() {
		
		boolean actResult = overview.verfiyPaymentLableText();

        Assert.assertTrue(actResult);
		Reporter.log("Payment lable shown in webpage:- "+ true);
	}
	
	
	@Test(enabled = true,groups = {"Smoke"})
	public void verfiyShopingInformationLableTextTest() {
		
		boolean actResult = overview.verfiyShopingInformationLableText();
		
		Assert.assertEquals(actResult, true);
		Reporter.log("Shopping Information lable shown in webpage:- "+actResult);
	}
	
	@Test(enabled = true,groups = {"Smoke"})
	public void verfiyPriceTotalLableTextTest() {
		
		boolean actResult = overview.verfiyPriceTotalLableText();

        Assert.assertTrue(actResult);
		Reporter.log("Price Total lable shown in webpage:- "+ true);
	}
	
	@Test(enabled = true,groups = {"Smoke"})
	public void verifycancleButtonTest() {
		
		boolean actResult = overview.verifycancleButton();

        Assert.assertTrue(actResult);
		Reporter.log("Cancel Button lable shown in webpage:- "+ true);
	}
	
	@Test(groups = {"Smoke"})
	public void verifyClickFinishButton() {
		
		String expResult = "https://www.saucedemo.com/checkout-complete.html";
		String actResult = overview.verifyClickFinishButton();
		
		Assert.assertEquals(actResult, expResult);
		Reporter.log("Cancel Button lable shown in webpage:- "+actResult);
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
