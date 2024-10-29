package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import Utility.ReadFileData;

public class _1_LoginPage extends TestBase {

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement userNameTextBox;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTextBox;
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginButton;

	public _1_LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyUserLogin() throws IOException {

		/* Create an extent report for Login Page */
		logger = report.createTest("Login to Sauce Lab Application");
		
		userNameTextBox.sendKeys(ReadFileData.readConfigData("Username"));
		logger.log(Status.INFO,"Username Entered");
		passwordTextBox.sendKeys(ReadFileData.readConfigData("Password"));
		logger.log(Status.INFO, "Password Entered");
		loginButton.click();
		logger.log(Status.INFO, "Login Button Clicked");
		logger.log(Status.PASS, "Login Succeed");

		return driver.getCurrentUrl();

	}

	public String verifyURL() {
		logger = report.createTest("Verify URL of Application");
		logger.log(Status.INFO, "URL of Application Is Available");
		logger.log(Status.PASS, "URL of Application is Verified");
		return driver.getCurrentUrl();
	}

	public String verifyTitle() {
		logger = report.createTest("Verify Title of Application");
		logger.log(Status.INFO, "Title of Application Is Available");
		logger.log(Status.PASS, "Title of Application is Verified");
		return driver.getTitle();
	}
	
	
	public String verifyMultipleUserLogin(String username, String password) {

		/* Create an extent report for Login Page */
		logger = report.createTest("Login to Sauce Lab Application");
		
		userNameTextBox.sendKeys(username);
		logger.log(Status.INFO,"Username Entered");
		passwordTextBox.sendKeys(password);
		logger.log(Status.INFO, "Password Entered");
		loginButton.click();
		logger.log(Status.INFO, "Login Button Clicked");
		logger.log(Status.PASS, "Login Succeed");

		return driver.getCurrentUrl();

	}
}
