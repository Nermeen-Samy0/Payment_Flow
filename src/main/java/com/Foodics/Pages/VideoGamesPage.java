package com.Foodics.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class VideoGamesPage extends MainPage {

    public VideoGamesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "s-refinements")
    private WebElement freeShippingDiv;

    @FindBy(id = "filters")
    private WebElement filterWithNewCondition;

    @FindBy(className = "aok-inline-block")
    private WebElement sortDropdown;

    @FindBy(className = "a-popover-inner")
    private WebElement sortValue;

    @FindBy(css = "div[data-component-type = 's-search-result']")
    private List<WebElement> listOfProducts;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    private List<WebElement> productCount;

    public void checkFreeShippingCheckbox() {
        List<WebElement> listOfDivs = freeShippingDiv.findElements(By.tagName("div"));
        clickOnElement(listOfDivs.get(2).findElement(By.tagName("ul")));
    }

    public void filterWithNew() {
        List<WebElement> conditionsList = filterWithNewCondition.findElements(By.tagName("ul"));
        clickOnElement(conditionsList.get(1).findElements(By.tagName("span")).get(1));
    }

    public void openPriceDropdown() {
        clickOnElement(sortDropdown);
    }

    public void sortByHighToLow() {
        clickOnElement(sortValue.findElement(By.tagName("ul")).findElements(By.tagName("li")).get(2));
    }
    public void selectListOfProducts(int amountCondition) {
        allSearchResults = driver.findElement(By.id("search")).findElements(By.className("a-price-whole"));
        for (int i = 0; i < allSearchResults.size(); i++) {
            Integer price = getPriceAsNumber(allSearchResults.get(i).getText());
            if (price < amountCondition) {
                itemsSelectedCount++;
                itemsSelectedTotalPrices += price;
                clickOnElement(allSearchResults.get(i));
                clickOnElement(addToCartButton);
                try {
                    WebElement sideSheet = driver.findElement(By.id("attach-desktop-sideSheet"));
                    if(sideSheet.getSize() != null) {
                        driver.findElement(By.id("attachSiNoCoverage")).click();
                        clickOnElement(addToCartButton);
                    }
                }catch (Exception ex) {
                    getListState();
                    continue;
                }
                getListState();
            }
        }
    }
    private void getListState() {
        driver.navigate().back();
        driver.navigate().back();
        allSearchResults = driver.findElement(By.id("search")).findElements(By.className("a-price-whole"));
    }
}