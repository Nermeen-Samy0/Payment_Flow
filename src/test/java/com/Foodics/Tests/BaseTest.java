package com.Foodics.Tests;

import com.Foodics.Pages.HomePage;
import com.Foodics.Pages.LoginPage;
import com.Foodics.Utilities.PropertiesFilesHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver;
    public JavascriptExecutor jsDriver;
    public PropertiesFilesHandler prop = new PropertiesFilesHandler();

    @Parameters({"url", "browserType"})
    @BeforeSuite(description = "Setting up selenium WebDriver before each class run")
    public void beforeClass(String url, String browserType) {
        switch (browserType) {
            case ("Chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case ("Firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        jsDriver = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get(url);
    }

    @BeforeClass(description = "Login successfully to the web in order to proceed in tests", alwaysRun = false)
    public void loginSuccessfully() {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            homePage.goToLoginPage();
            loginPage.loginSuccessfully(prop.getUserEmail() , prop.getUserPassword());
        }

    @AfterClass
    public void afterTest() {
         driver.quit();
    }
}
