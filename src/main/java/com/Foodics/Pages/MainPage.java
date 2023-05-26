package com.Foodics.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class MainPage {

    public  WebDriver driver;
    public static int itemsSelectedCount;
    public static int cartItemsCount;
    public static double totalAmount;
    public static double itemsSelectedTotalPrices;
    List<WebElement> allSearchResults = new ArrayList<>();

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnElement(WebElement element) {
        element.click();
    }
    public void enterText(WebElement element, String text) {
       element.sendKeys(text);
    }
    public Integer getPriceAsNumber(String price) {
        if (price.contains(","))
            price = price.replace(",", "");
        if (price.contains("EGP"))
            price = price.replace("EGP", "");
        if (price.contains(".00"))
            price = price.replace(".00", "");
        if (price.contains("  "))
            price = price.replace("  ", "");
        return Integer.parseInt(price);
    }
}
