package com.Foodics.Tests;

import com.Foodics.Pages.CheckoutPage;
import com.Foodics.Pages.HomePage;
import com.Foodics.Pages.VideoGamesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {

    HomePage homePage;
    VideoGamesPage videoGamesPage;
    CheckoutPage checkoutPage;

   @Test
   public void openAllMenuBar() {
       homePage = new HomePage(driver);
       videoGamesPage = new VideoGamesPage(driver);
       checkoutPage = new CheckoutPage(driver);
       homePage.openAllMenuBar();
   }

    @Test public void clickOnSeeAll() {
       homePage.clickSeeAllButton();
   }
    @Test public void openVideoGames() {
        homePage.clickVideoGamesButton();
    }
    @Test public void openAllVideoGames() {
       homePage.clickAllVideoGamesButton();
    }
    @Test public void getListOfProducts() {
        videoGamesPage.selectListOfProducts(Integer.parseInt(prop.getAmountCondition()));
    }
    @Test public void clickOnFreeShipping() {
        videoGamesPage.checkFreeShippingCheckbox();
    }
    @Test public void filterWithNewCondition() {
        videoGamesPage.filterWithNew();
    }
    @Test public void openPriceDropdown(){
        videoGamesPage.openPriceDropdown();
    }
    @Test public void sortByHighToLow() {
        videoGamesPage.sortByHighToLow();
    }
    @Test public void openCartContainer() {
       homePage.openCartContainer();
    }
    @Test public void validateTotalPriceAndProductCount() {
        Assert.assertTrue(homePage.checkTotalPriceAndProductCount());
    }
    @Test public void proceedToRetailCheckout() {
        homePage.proceedToRetailCheckout();
    }
    @Test public void enterAddressFullName() {
        checkoutPage.enterAddressFullName(prop.getAddressFullName());
    }
    @Test public void enterAddressPhoneNumber() {
        checkoutPage.enterAddressPhoneNumber(prop.getAddressPhoneNumber());
    }
    @Test public void enterAddressLine1() {
        checkoutPage.enterAddressLine1(prop.getAddressLine1());
    }
    @Test public void enterBuildingNameOrNumber() {
       checkoutPage.enterBuildingNameOrNumber(prop.getBuildingNameOrNumber());
    }
    @Test public void enterAddressCity() {
        checkoutPage.enterAddressCity(prop.getAddressCity());
    }
    @Test public void enterAddressDistrictOrCounty() {
        checkoutPage.enterAddressDistrictOrCounty(prop.getAddressDistrictOrCounty());
    }
    @Test public void enterAddressLandmark() {
        checkoutPage.enterAddressLandmark(prop.getAddressLandmark());
    }
    @Test public void submitTheAddress() {
       checkoutPage.submitTheAddress();
    }

}
