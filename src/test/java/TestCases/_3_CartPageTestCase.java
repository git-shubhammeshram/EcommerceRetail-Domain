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
import Utility.CaptureScreenShot;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _3_CartPageTestCase extends TestBase {

	_3_CartPage cart;

	@BeforeMethod(alwaysRun = true)
	public void intit() throws IOException, InterruptedException {
		initialization();

		_1_LoginPage login = new _1_LoginPage();
		login.verifyUserLogin();
		_2_InventoryPage inventory = new _2_InventoryPage();
		inventory.varifyAddSixProductIntoCart();
		inventory.clickOnCart();

		cart = new _3_CartPage();

	}
	
	@Test(groups = {"Smoke","Sanity"})
	public void verifyCartPageURLTest() {
		String expResult = "https://www.saucedemo.com/cart.html";
		String actResult = cart.verifyCartPageURL();
		
		Assert.assertEquals(actResult, expResult);
		Reporter.log("After adding the product into cart and clicking on cart button showing current page URL:-"+actResult);
	}
	
	
	@Test(groups = {"Smoke","Sanity"})
	public void verifyCartPageTitleTest() {
		String expResult = "Your Cart";
		String actResult = cart.verifyCartPageTitle();
		
		Assert.assertEquals(actResult, expResult);
		Reporter.log("Title showing into webpage is:- "+actResult);

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
