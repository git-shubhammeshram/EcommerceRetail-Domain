package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;
import Utility.CaptureScreenShot;
import Utility.ReadFileData;

public class _2_InventoryPageTestCase extends TestBase {

	_1_LoginPage login;
	_2_InventoryPage inventory;

	@BeforeMethod(alwaysRun = true)
	public void intit() throws InterruptedException, IOException {
		initialization();
		login = new _1_LoginPage();
		login.verifyUserLogin();

		inventory = new _2_InventoryPage();
	}

	@Test(priority = 0,groups = {"Regression"})
	public void verifyProductPageTitleTest() throws EncryptedDocumentException, IOException {
		String expResult = ReadFileData.readExcelData(1, 3);
		String actResult = inventory.verifyProductPageTitle();

		Assert.assertEquals(actResult, expResult);
		Reporter.log("ProductPage title as shown in webpage is:- " + actResult);
	}

	/* Fails TestCases are shown in testing-failed.xml */

	@Test(priority = 1,groups = {"Sanity"})
	public void verfiyApplicationLogo() {
		boolean expResult = inventory.verfiyApplicationLogo();

		Assert.assertEquals(expResult, true);
		Reporter.log("Application Logo shown in webpage:- " + expResult);
	}

	@Test(priority = 2,groups = {"Sanity"})
	public void verifyCartIconTest() {
		boolean expResult = inventory.verifyCartIcon();

		Assert.assertEquals(expResult, true);
		Reporter.log("Cart Logo shown in webpage:- " + expResult);
	}

	@Test(priority = 6,groups = {"Sanity"})
	public void verifyTwitterSocialIconTest() {
		boolean expResult = inventory.verifyTwitterSocialIcon();

		Assert.assertEquals(expResult, true);
		Reporter.log("Twitter Icon shown in webpage:- " + expResult);
	}

	@Test(priority = 7,groups = {"Sanity"})
	public void verifyFacbookSocialIconTest() {
		boolean expResult = inventory.verifyFacbookSocialIcon();

		Assert.assertEquals(expResult, true);
		Reporter.log("Facebook Icon shown in webpage:- " + expResult);
	}

	@Test(priority = 8,groups = {"Sanity"})
	public void verifyLinkedInSocialIconTest() {
		boolean expResult = inventory.verifyLinkedInSocialIcon();

		Assert.assertEquals(expResult, true);
		Reporter.log("LinkedIn Icon shown in webpage:- " + expResult);
	}

	@Test(priority = 5,groups = {"Sanity"})
	public void verifyCopyRightsTextTest() {
		boolean expResult = inventory.verifyCopyRightsText();

		Assert.assertEquals(expResult, true);
		Reporter.log("CopyRights Text shown in webpage:- " + expResult);
	}

	@Test(enabled = true, priority = 3,groups = {"Sanity"})
	public void varifyAddSixProductIntoCartTest() throws InterruptedException, EncryptedDocumentException, IOException {
		String expResult = ReadFileData.readExcelData(1, 4);
		String actResult = inventory.varifyAddSixProductIntoCart();

		Assert.assertEquals(expResult, actResult);
		Reporter.log("Aftre adding the product into cart, cart value count is:- " + actResult);
	}

	@Test(enabled = false, priority = 4,groups = {"Somke"})
	public void verifyRemoveTwoProductFromCartTest()
			throws InterruptedException, EncryptedDocumentException, IOException {

		String expResult = ReadFileData.readExcelData(1, 5);
		String actResult = inventory.verifyRemoveTwoProductFromCart();

		Assert.assertEquals(expResult, actResult);
		Reporter.log("After removing two product the cart value is:- " + actResult);
	}

	

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws IOException {
		if(result.FAILURE == result.getStatus()) {
			CaptureScreenShot.getScreenShots(result.getName());
		}
		driver.close();
	}

}
