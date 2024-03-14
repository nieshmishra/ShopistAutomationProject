package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage extends TestBase {

    @FindBy (xpath="//div[@aria-label='main navigation']")
    WebElement homePage;
    @FindBy (xpath="//a[contains(@class, 'chairs')]")
    WebElement chairsMenuItem;
    @FindBy (xpath="//a[contains(@class, 'profile')]")
    WebElement profile;

    @FindBy (xpath="//div[contains(@class, 'product')]")
    WebElement productsList;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnChairsMenu() {
        chairsMenuItem.click();
    }

    public void clickOnProfile() {
        profile.click();
    }

    public boolean verifyHomePageDisplayed() {
        return homePage.isDisplayed();
    }

    public boolean verifyProductsListIsDisplayed() {
        return productsList.isDisplayed();
    }

}
