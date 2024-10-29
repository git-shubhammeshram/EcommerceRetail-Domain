package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.HandleDropDown;
import Utility.ReadFileData;

public class _2_InventoryPage extends TestBase {

	@FindBy(xpath = "//span[@class='title']")
	WebElement productPageTitleText;
	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement applicationLogo;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement shoppingCartIcon;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement sortNameText;

	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']")
	WebElement oneSieTshirtProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']")
	WebElement bikeLightProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")
	WebElement boltTshirtProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']")
	WebElement redTshirtProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']")
	WebElement blackBagProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']")
	WebElement jacketProduct;

	@FindBy(xpath = "//button[@name='remove-sauce-labs-fleece-jacket']")
	WebElement removeJacketProduct;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-backpack']")
	WebElement removeBlackBagProduct;

	@FindBy(xpath = "//a[text()='Twitter']")
	WebElement twitterSocialIcon;
	@FindBy(xpath = "//a[text()='Facebook']")
	WebElement facebookSocialIcon;
	@FindBy(xpath = "//a[text()='LinkedIn']")
	WebElement LinkedInSocialIcon;
	@FindBy(xpath = "//div[@class='footer_copy']")
	WebElement copyRightsText;

	public _2_InventoryPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyProductPageTitle() {
		return productPageTitleText.getText();
	}

	public boolean verfiyApplicationLogo() {
		return applicationLogo.isDisplayed();
	}

	public boolean verifyCartIcon() {
		return shoppingCartIcon.isDisplayed();
	}

	public boolean verifyTwitterSocialIcon() {
		return twitterSocialIcon.isDisplayed();
	}

	public boolean verifyFacbookSocialIcon() {
		return facebookSocialIcon.isDisplayed();
	}

	public boolean verifyLinkedInSocialIcon() {
		return LinkedInSocialIcon.isDisplayed();
	}

	public boolean verifyCopyRightsText() {
		return copyRightsText.isDisplayed();
	}

	public String varifyAddSixProductIntoCart() throws InterruptedException, EncryptedDocumentException, IOException {
		HandleDropDown.getSelectClass(sortNameText, ReadFileData.readExcelData(1, 6));
	
		oneSieTshirtProduct.click();
		bikeLightProduct.click();
		boltTshirtProduct.click();
		redTshirtProduct.click();
		blackBagProduct.click();
		jacketProduct.click();

		return shoppingCartIcon.getText();

	}

	public String verifyRemoveTwoProductFromCart() throws InterruptedException, EncryptedDocumentException, IOException {
		
		varifyAddSixProductIntoCart();

		removeJacketProduct.click();
		removeBlackBagProduct.click();

		return shoppingCartIcon.getText();
		

	}
	
	public void clickOnCart() {
		shoppingCartIcon.click();
	}

}
