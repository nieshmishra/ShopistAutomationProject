package tests;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ProfilePage;

public class TestRunner {

    HomePage homePage;
    ProfilePage profilePage;

    @BeforeTest
    public void init() {
        homePage = new HomePage();
        profilePage = new ProfilePage();
        this.homePage.getDriver().navigate().refresh();
    }

    @Test(priority = 0)
    public void verifyNavigationMenu() {
        Assert.assertTrue(homePage.verifyHomePageDisplayed());
        homePage.clickOnChairsMenu();
        Assert.assertTrue(homePage.verifyProductsListIsDisplayed());
    }

    @Test(priority = 1)
    public void verifyUpdateProfileIsSuccessful() {
        Assert.assertTrue(homePage.verifyHomePageDisplayed());
        homePage.clickOnProfile();
        profilePage.clickOnEditProfile();
        profilePage.updateMobileNumber("9876543210");
        Assert.assertTrue(profilePage.isSuccessBannerDisplayed());
    }

    @Test(priority = 2)
    public void verifyUpdateProfileShouldFail() {
        Assert.assertTrue(homePage.verifyHomePageDisplayed());
        homePage.clickOnProfile();
        profilePage.clickOnEditProfile();
        profilePage.updateMobileNumber("INVALID_MOBILE");
        Assert.assertFalse(profilePage.isSuccessBannerDisplayed());
    }

    @AfterClass
    public void tearDown() {
        homePage.getDriver().quit();
    }
}
