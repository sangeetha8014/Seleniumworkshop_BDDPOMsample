package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchResultPage extends TestBase {

	@FindBy(linkText = "Search")
	WebElement searchBar;

	@FindBy(xpath = "//button[contains(@onclick,\"cart.add\")]")
	WebElement listedItem;

	@FindBy(css = "span#cart-total")
	WebElement cartTotal;
	
//	@FindBy(css = "div.product-thumb")
//	List<WebElement> items;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	public void addToCart() {
		listedItem.click();
	}

	public boolean isItemAdded() {
		String total = cartTotal.getText();

		// "i items(s) - $123.20"
		System.out.println("Cart Total : " + cartTotal.getText());
		String[] itemNum = total.split(" ");
		System.out.println("Item count : " + itemNum[0]);
		int itemCount = Integer.parseInt(itemNum[0]);
		if (itemCount > 0)
			return true;
		else
			return false;

	}

}
