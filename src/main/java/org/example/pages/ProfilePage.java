package org.example.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class ProfilePage {
    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//img[@class='avatar circle']")
    private WebElement editImg;

    @FindBy(xpath = "//span[contains(text(),'Your profile')]")
    private WebElement yourProfile;

    @FindBy(xpath = "//button[normalize-space()='Edit profile']")
    private WebElement editProfile;

    @FindBy(xpath = "//input[@id='user_profile_name']")
    private WebElement nameField;

    @FindBy(xpath = "//button[@class='Button--primary Button--small Button d-inline-flex']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[@class='p-name vcard-fullname d-block overflow-hidden']")
    private WebElement updatedName;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void iconImgEdit() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(editImg)).click();
        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Edit image icon not found or not clickable: " + e.getMessage());
        }
    }

    public void setEditYourProfile() {
        try {
            wait.until(ExpectedConditions.visibilityOf(yourProfile));
            wait.until(ExpectedConditions.elementToBeClickable(yourProfile)).click();
        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Your Profile option not found or not clickable: " + e.getMessage());
        }
    }

    public void setEditProfile() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(editProfile)).click();
        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Edit profile button not found or not clickable: " + e.getMessage());
        }
    }

    public void clickNameField() {
        try {
            wait.until(ExpectedConditions.visibilityOf(nameField)).click();
        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Name field not found or not visible: " + e.getMessage());
        }
    }

    public void setNameField(String username) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(nameField));
            nameField.sendKeys(username);
            Thread.sleep(1000);
        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Name field not found or not visible: " + e.getMessage());
        }
    }

    public void setSaveButton() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
            Thread.sleep(1000);
        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Save button not found or not clickable: " + e.getMessage());
        }
    }

    public void navigatePage() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Navigation button not found or not clickable: " + e.getMessage());
        }
    }

    public String getUpdatedName() {
        try {
            wait.until(ExpectedConditions.visibilityOf(updatedName));
            return updatedName.getText();
        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Updated name element not found or not visible: " + e.getMessage());
            return "";
        }
    }
}
