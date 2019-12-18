package com.rl.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rl.qa.base.TestBase;

public class FavoritesPage extends TestBase {
	@FindBy(xpath = "//span[@class='saved-text']")
	private WebElement NumberOfFavoritesItems;

	@FindBy(xpath = "(//img[@class='default-img'])")
	private List<WebElement> favoritesProductImage;

	public FavoritesPage() {
		PageFactory.initElements(driver, this);
	}

	public int verifyNumberofFavItems() {
		String number = NumberOfFavoritesItems.getText();
		char[] carray = number.toCharArray();
		int d = 0;
		for (char c : carray) {
			if (Character.isDigit(c)) {
				d = Character.getNumericValue(c);
			}
		}
		return d;
	}

	public int verifyNumberoFProducts() {
		int count = favoritesProductImage.size();
		return count;
	}
}