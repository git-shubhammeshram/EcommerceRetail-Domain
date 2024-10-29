package TestCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;
import Utility.CaptureScreenShot;
import Utility.ReadFileData;

public class _7_LoginPageWithMultipleCrediantialsTest extends TestBase {

	_1_LoginPage login;
	_2_InventoryPage _2_InventoryPage;

	@BeforeMethod(alwaysRun = true)
	public void init() throws InterruptedException, IOException {
		initialization();
		login = new _1_LoginPage();
	}
	
	
	@Test(dataProvider = "credentials")
	public void verifyUserLoginTest(String username, String password) throws IOException {

		SoftAssert softAssert = new SoftAssert();
		
		String expResult = ReadFileData.readExcelData(1, 2);
		String actResult = login.verifyMultipleUserLogin(username,password);

		softAssert.assertEquals(actResult, expResult);
		Reporter.log("After user login the URL is :- " + actResult);
		
		softAssert.assertAll();

	}
	
	@DataProvider(name = "credentials")
	public String [][] getData() {
		return new String[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"visual_user","secret_sauce"}
		};
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
