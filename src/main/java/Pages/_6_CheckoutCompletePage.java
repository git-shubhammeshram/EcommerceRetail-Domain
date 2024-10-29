package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _6_CheckoutCompletePage extends TestBase {
	
	@FindBy(xpath = "//span[@class='title']") WebElement orderCompleteLabel;
	@FindBy(xpath = "//img[@class='pony_express']") WebElement successLogo;
	@FindBy(xpath = "//h2[@class='complete-header']") WebElement greatingTextLabel;
	@FindBy(xpath = "//div[@class='complete-text']") WebElement orderSummaryTextLabel;
	@FindBy(xpath = "//button[@id='back-to-products']") WebElement backToHomeButton;
	
	public _6_CheckoutCompletePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOrderCompletePageURL() {
		return driver.getCurrentUrl();
	}
	
	public String verifyOrderCompleteLabel() {
		return orderCompleteLabel.getText();
	}
	
	public boolean verifySuccessLogo() {
		return successLogo.isDisplayed();
	}
	
	public String verifyGreatingTextLabel() {
		return greatingTextLabel.getText();
	}
	
	public String verifyOrderSummaryTextLabel() {
		return orderSummaryTextLabel.getText();
	}
	
	
	public boolean verifyBackToHomeButton() {
		return backToHomeButton.isDisplayed();
	}

	

 
}
