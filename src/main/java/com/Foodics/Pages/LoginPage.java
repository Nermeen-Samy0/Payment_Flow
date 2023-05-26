package com.Foodics.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MainPage{

    @FindBy(id = "ap_email")
    private WebElement userEmail;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement userPassword;

    @FindBy(id = "signInSubmit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver)  {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterEmailAddress(String userEmailAddress) {
        enterText(userEmail, userEmailAddress);
    }
    public void pressContinue() {
        clickOnElement(continueButton);
    }
    public void enterUserPassword(String UserPassword) {
        enterText(userPassword, UserPassword);
    }
    public void submitLogin() {
        clickOnElement(submitButton);
    }
    public void loginSuccessfully(String userEmailAddress, String UserPassword){
        userEmail.sendKeys(userEmailAddress);
        clickOnElement(continueButton);
        userPassword.sendKeys(UserPassword);
        clickOnElement(submitButton);
    }
}

