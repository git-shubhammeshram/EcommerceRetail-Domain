package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _3_CartPage extends TestBase {
	
	@FindBy(xpath = "//span[text()='Your Cart']") WebElement cartPageTitle;
	@FindBy(xpath = "//button[@id='checkout']") WebElement checkoutButton;
	
	public _3_CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCartPageURL() {
		return driver.getCurrentUrl();
	}
	
	public String verifyCartPageTitle() {
		 return cartPageTitle.getText();
	}
	
	public void verifyCheckoutButton() {
		 checkoutButton.click();
	}

}
