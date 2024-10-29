package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _7_LogoutPage extends TestBase {

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement menuButton;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logoutButton;

	public _7_LogoutPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyUserLogout() {
		menuButton.click();
		logoutButton.click();

		return driver.getCurrentUrl();
	}
}
