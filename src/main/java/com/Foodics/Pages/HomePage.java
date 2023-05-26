package com.Foodics.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage extends MainPage {

    public HomePage(WebDriver driver)  {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement loginButton;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement allMenuButton;

    @FindBy(xpath = "//*[contains(text(),'see all')]")
    private WebElement seeAllButton;

    @FindBy(className = "hmenu-compress-section")
    private WebElement ulElement;
    private List<WebElement> liList;

    @FindBy(xpath = "//a[@href='/-/en/gp/browse.html?node=18022560031&ref_=nav_em_vg_all_0_2_16_2']")
    private WebElement allVideosElement;

    @FindBy(id = "nav-cart-count-container")
    private WebElement cartContainer;

    @FindBy(id = "sc-subtotal-amount-buybox")
    private WebElement totalPrice;

    @FindBy(name = "proceedToRetailCheckout")
    private WebElement proceedToCheckout;

    public void goToLoginPage() {
        clickOnElement(loginButton);
    }
    public void openAllMenuBar() {
        clickOnElement(allMenuButton);
    }
    public void clickSeeAllButton() {
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(seeAllButton);
    }
    public void clickVideoGamesButton() {
        liList = ulElement.findElements(By.tagName("li"));
        clickOnElement(liList.get(10));
    }
    public void clickAllVideoGamesButton() {
        clickOnElement(allVideosElement);
    }
    public void openCartContainer() {
        clickOnElement(cartContainer);
        cartItemsCount = Integer.parseInt(cartContainer.getText());
        totalAmount = getPriceAsNumber(totalPrice.getText());
    }
    public boolean checkTotalPriceAndProductCount() {
        if(cartItemsCount == itemsSelectedCount && totalAmount == itemsSelectedTotalPrices) {
            return true;
        }else {
            return false;
        }
    }
    public void proceedToRetailCheckout() {
        clickOnElement(proceedToCheckout);
    }
}
