package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class LogoutPage {
    private WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(LogoutPage.class);

    @FindBy(xpath = "//img[@class='avatar circle']")
    private WebElement editImg;

    @FindBy(xpath = "//span[contains(text(),'Sign out')]")
    private WebElement signOut;

    @FindBy(xpath = "//input[@value='Sign out from all accounts']")
    private WebElement signOutPage;

    @FindBy(xpath = "(//a[contains(text(), 'Sign in')])[2]")
    private WebElement signInButton;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void clickedEditImg() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(editImg)).click();
        } catch (Exception e) {
            logger.error("Failed to click on edit image: {}", e.getMessage());
        }
    }

    public void scrollToElementAndClick() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(signOut));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", signOut);
            wait.until(ExpectedConditions.elementToBeClickable(signOut)).click();
        } catch (Exception e) {
            logger.error("Failed to scroll to and click sign out: {}", e.getMessage());
        }
    }

    public String setSignOutPage() {
        try {
            Thread.sleep(2000);
            String message = wait.until(ExpectedConditions.visibilityOf(signOutPage)).getAttribute("value");
            return message;
        } catch (Exception e) {
            logger.error("Failed to get sign out page value: {}", e.getMessage());
            return null;
        }
    }
    public void navigateToSignInPage() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(signOutPage)).click();
            wait.until(ExpectedConditions.visibilityOf(signInButton));
            logger.info("Navigated to the Sign-In page successfully.");
        } catch (Exception e) {
            logger.error("Failed to navigate to the Sign-In page: " + e.getMessage());
            Assert.fail("Navigation to Sign-In page failed due to: " + e.getMessage());
        }
    }


}
