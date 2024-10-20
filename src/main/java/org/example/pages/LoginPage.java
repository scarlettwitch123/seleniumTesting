package org.example.pages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "(//a[contains(text(), 'Sign in')])[2]")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement userField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement submitSignIn;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[contains(@class,'AppHeader-context-item')]")
    private WebElement navigateDashboard;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(userField));
        userField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submitSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitSignIn)).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public String successNavigateDashboard() {
        wait.until(ExpectedConditions.visibilityOf(navigateDashboard));
        return navigateDashboard.getText();
    }
}
