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
import Pages._6_CheckoutCompletePage;
import Utility.CaptureScreenShot;
import Pages._4_CheckoutPage;
import Pages._5_CheckoutPageOverviewPage;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _6_CheckoutCompletePageTest extends TestBase {
	
	_6_CheckoutCompletePage checkoutComplete;

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
		
		_5_CheckoutPageOverviewPage overview = new _5_CheckoutPageOverviewPage();
		overview.verifyClickFinishButton();
		
		 checkoutComplete = new _6_CheckoutCompletePage();
		
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyOrderCompletePageURLTest() {
		
		String expResult = "https://www.saucedemo.com/checkout-complete.html";
		String actResult = checkoutComplete.verifyOrderCompletePageURL();
		
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Order complete page URL is:- "+actResult);
		
	}
	
	
	
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyOrderCompleteLabelTest() {
		String expResult = "Checkout: Complete!";
		String actResult = checkoutComplete.verifyOrderCompleteLabel();
		
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Checkout Lable shown in webpage is:- "+actResult);
		
	}

	@Test(groups = {"Regression","Sanity"})
	public void verifySuccessLogoTest() {
		boolean actResult = checkoutComplete.verifySuccessLogo();

        Assert.assertTrue(actResult);
		Reporter.log("logo shown in webpage is:- "+ true);
		
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyCreatingTextLabelTest() {
		String expResult = "Thank you for your order!";
		String actResult = checkoutComplete.verifyGreatingTextLabel();
		
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Greating shown in webpage is:- "+actResult);
		
	}
	
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyOrderSummaryTextLabelTest() {
		String expResult = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actResult = checkoutComplete.verifyOrderSummaryTextLabel();
		
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Order summary shown in webpage is:- "+actResult);
		
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyBackToHomeButtonTest() {
		boolean actResult = checkoutComplete.verifyBackToHomeButton();
        Assert.assertTrue(actResult);
		Reporter.log("Back to Home button shown in the webpage:- "+ true);
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
