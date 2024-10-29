package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _4_CheckoutPage extends TestBase{
	
	@FindBy(xpath = "//input[@id='first-name']") WebElement firstNameTextBox ;
	@FindBy(xpath = "//input[@id='last-name']") WebElement lastNameTextBox ;
	@FindBy(xpath = "//input[@id='postal-code']") WebElement postalcodeTextBox ;
	@FindBy(xpath = "//input[@id='continue']") WebElement continueButton ;
	
	public _4_CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckOutPageURL() {
		return driver.getCurrentUrl();
	}
	
	
	public String verifyCheckOutPageTitle() {
		return driver.getTitle();
	}
	
	public String verfiyAddCheckOutDetailsTest() {
		firstNameTextBox.sendKeys("Shubham");
		lastNameTextBox.sendKeys("Meshram");
		postalcodeTextBox.sendKeys("444607");
		
		continueButton.click();
		return driver.getCurrentUrl();
	}


}
