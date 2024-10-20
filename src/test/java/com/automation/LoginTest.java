package com.automation;

import org.example.base.TestBase;
import org.example.pages.LoginPage;
import org.example.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);

    }


    @Test(priority = 1)
    public void testValidLogin() throws InterruptedException {
        loginPage.clickSignIn();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.submitSignInButton();
        String actualMessage = loginPage.successNavigateDashboard();
        Assert.assertTrue(actualMessage.contains("Dashboard"), "Login failed");
    }

    @Test(enabled = false)
    public void testInvalidLogin() throws InterruptedException {
        loginPage.clickSignIn();
        loginPage.enterUsername(incorrectUsername);
        loginPage.enterPassword(incorrectPassword);
        loginPage.submitSignInButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Incorrect username or password."),
                "Expected error message for invalid login not displayed.");
    }
}
