package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(@class,'AppHeader-context-item')]")
    private WebElement dashboardElement;

    @FindBy(xpath = "//span[contains(text(),'New')]")
    private WebElement dashboardNewButton;

    @FindBy(xpath = "//span[contains(text(),'Create repository')]")
    private WebElement dashboardNewButtonCreate;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(dashboardElement));
        return dashboardElement.isDisplayed();
    }

    public boolean isDashboardButtonPresent() {
        wait.until(ExpectedConditions.visibilityOf(dashboardNewButton));
        return dashboardNewButton.isDisplayed();
    }

    public void isDashboardButtonCreate() {
        wait.until(ExpectedConditions.visibilityOf(dashboardNewButtonCreate));
        dashboardNewButtonCreate.click();
    }

}
