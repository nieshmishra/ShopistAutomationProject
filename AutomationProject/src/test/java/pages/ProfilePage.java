package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends TestBase {

    @FindBy (xpath="//a[text()='Edit Profile']")
    WebElement editProfileBtn;

    @FindBy (xpath="//button[text()='Save profile']")
    WebElement saveProfileBtn;
    @FindBy (xpath="//div[contains(text(), 'Profile successfully saved')]")
    WebElement successBanner;

    @FindBy (id="phone")
    WebElement mobileNumberTxt;

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnEditProfile() {
        editProfileBtn.click();
    }
    public void updateMobileNumber(String mobileNumber) {
        mobileNumberTxt.clear();
        mobileNumberTxt.sendKeys(mobileNumber);
        saveProfileBtn.click();
    }

    public boolean isSuccessBannerDisplayed() {
        return successBanner.isDisplayed();
    }

}
