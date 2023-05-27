package com.Foodics.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends MainPage {

    Duration duration;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        duration = Duration.ofSeconds(1000);
        wait = new WebDriverWait(driver, duration);
    }

    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    private WebElement addressFullName;

    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    private WebElement addressPhoneNumber;

    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    private WebElement addressLine1;

    @FindBy(id = "address-ui-widgets-enter-building-name-or-number")
    private WebElement buildingNameOrNumber;

    @FindBy(id = "address-ui-widgets-enterAddressCity")
    private WebElement addressCity;

    @FindBy(id = "address-ui-widgets-enterAddressDistrictOrCounty")
    private WebElement addressDistrictOrCounty;

    @FindBy(id = "address-ui-widgets-enterAddressStateOrRegion")
    private WebElement addressStateOrRegion;

    @FindBy(id = "address-ui-widgets-landmark")
    private WebElement addressLandmark;

    @FindBy(id = "address-ui-widgets-form-submit-button")
    private WebElement submitButton;

    @FindBy(className = "a-box-group")
    private WebElement paymentMethodGroup;


    public void enterAddressFullName(String addFullName) {
        enterText(addressFullName, addFullName);
    }
    public void enterAddressPhoneNumber(String addPhoneNumber) {
        enterText(addressPhoneNumber, addPhoneNumber);
    }
    public void enterAddressLine1(String addLine1) {
        enterText(addressLine1, addLine1);
    }
    public void enterBuildingNameOrNumber(String buildingNameOrNum) {
        enterText(buildingNameOrNumber, buildingNameOrNum);
    }
    public void enterAddressCity(String addCity) {
        enterText(addressCity, addCity);
        waitVisibilityOfElement("autoCompleteResult", 1);
    }
    public void enterAddressDistrictOrCounty(String addDistrictOrCounty) {
        enterText(addressDistrictOrCounty, addDistrictOrCounty);
        waitVisibilityOfElement("autoCompleteResult", 0);
    }
    public void enterAddressLandmark(String addLandmark) {
        enterText(addressLandmark, addLandmark);
    }
    public void submitTheAddress() {
        clickOnElement(submitButton);
    }

    private void waitVisibilityOfElement(String optionLocator, int index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(optionLocator)));
        WebElement autoOptions = driver.findElement(By.className(optionLocator));
        List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
        if(index <= optionsToSelect.size()) {
            optionsToSelect.get(index).click();
        }
    }
}
