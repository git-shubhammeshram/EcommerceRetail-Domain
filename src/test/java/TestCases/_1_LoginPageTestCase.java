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

public class _1_LoginPageTestCase extends TestBase {

    _1_LoginPage login;
    _2_InventoryPage _2_InventoryPage;

    @BeforeMethod(alwaysRun = true)
    public void init() throws InterruptedException, IOException {
        initialization();
        login = new _1_LoginPage();
    }


    @Test(enabled = true, priority = 0, groups = {"Regression", "Sanity"}, invocationCount = 3, timeOut = 2000)
    public void verifyURLTest() throws EncryptedDocumentException, IOException {


        String expResult = ReadFileData.readExcelData(1, 0);
        String actResult = login.verifyURL();

        Assert.assertEquals(expResult, actResult);
        Reporter.log("Original URL is :- " + actResult);

    }


    @Test(enabled = true, priority = 1, dependsOnMethods = "verifyURLTest", groups = {"Regression", "Sanity"})
    public void verifyTitleTest() throws EncryptedDocumentException, IOException {
        String expResult = ReadFileData.readExcelData(1, 1);
        String actResult = login.verifyTitle();

        Assert.assertEquals(expResult, actResult);
        Reporter.log("Original title shown in  :- " + actResult);

    }

    @Test(enabled = true, priority = 2, dependsOnMethods = "verifyURLTest", groups = {"Regression", "Sanity"})
    public void verifyUserLoginTest() throws IOException {

        String expResult = ReadFileData.readExcelData(1, 2);
        String actResult = login.verifyUserLogin();

        Assert.assertEquals(actResult, expResult);
        Reporter.log("After user login the URL is :- " + actResult);

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            CaptureScreenShot.getScreenShots(result.getTestName());
        }
        report.flush();
        driver.close();
    }

}
