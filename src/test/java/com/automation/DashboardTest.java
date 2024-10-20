package com.automation;

import org.example.base.TestBase;
import org.example.pages.LoginPage;
import org.example.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends TestBase {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void testDashboardNavigation() {
        try {
            loginPage = new LoginPage(driver);
            loginPage.clickSignIn();
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.submitSignInButton();
            dashboardPage = new DashboardPage(driver);
        } catch (Exception e) {
            System.err.println("An error occurred during dashboard navigation: " + e.getMessage());
            Assert.fail("Setup failed due to: " + e.getMessage());
        }
    }

    @Test
    public void testDashboardElements() {
        try {
            Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed!");
            Assert.assertTrue(dashboardPage.isDashboardButtonPresent(), "Dashboard Button is not present!");
//            Assert.assertTrue(dashboardPage.isDashboardButtonCreate(), "Another Dashboard Button is not present!");
        } catch (Exception e) {
            System.err.println("An error occurred while verifying dashboard elements: " + e.getMessage());
            Assert.fail("Test failed due to: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            super.tearDown();
        } catch (Exception e) {
            System.err.println("An error occurred during teardown: " + e.getMessage());
        }
    }
}
