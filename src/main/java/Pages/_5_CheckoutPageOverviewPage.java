package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _5_CheckoutPageOverviewPage extends TestBase {
	
	@FindBy(xpath = "//span[text()='Checkout: Overview']") WebElement overviewPageTitleText;
	@FindBy(xpath = "//div[text()='QTY']") WebElement qtyLableText;
	@FindBy(xpath = "//div[text()='Description']") WebElement descriptionLableText;
	@FindBy(xpath = "//div[text()='Payment Information:']") WebElement paymentLableText;
	@FindBy(xpath = "//div[text()='Shipping Information:']") WebElement shopingInformationLableText;
	@FindBy(xpath = "//div[text()='Price Total']") WebElement priceTotalLableText;
	@FindBy(xpath = "//button[@id='cancel']") WebElement cancleButton;
	@FindBy(xpath = "//button[@id='finish']") WebElement finishButton;
	
	public _5_CheckoutPageOverviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOverviewPageTitleText() {
		return overviewPageTitleText.getText();
	}
	
	public boolean verifyQtyLableText() {
		return qtyLableText.isDisplayed();
	}
	
	public boolean verifyDescriptionLableText() {
		return descriptionLableText.isDisplayed();
	}
	
	public boolean verfiyPaymentLableText() {
		return paymentLableText.isDisplayed();
	}
	
	public boolean verfiyShopingInformationLableText() {
		return shopingInformationLableText.isDisplayed();
	}
	
	public boolean verfiyPriceTotalLableText() {
		return priceTotalLableText.isDisplayed();
	}
	
	public boolean verifycancleButton() {
		return cancleButton.isDisplayed();
	}
	
	public String verifyClickFinishButton() {
		 finishButton.click();
		return driver.getCurrentUrl();
	}
	
	

	
	
	



}
