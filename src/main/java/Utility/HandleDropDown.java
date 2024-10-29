package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {

	public static void getSelectClass(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);

	}
}
