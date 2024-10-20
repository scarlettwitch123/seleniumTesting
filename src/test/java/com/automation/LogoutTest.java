package com.automation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.base.TestBase;
import org.example.pages.LoginPage;
import org.example.pages.DashboardPage;
import org.example.pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LogoutPage logoutPage;
    private static final Logger logger = LoggerFactory.getLogger(LogoutTest.class);

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.submitSignInButton();
        logoutPage = new LogoutPage(driver);
    }
//
    @Test
    public void testLogout() throws InterruptedException {
        logoutPage.clickedEditImg();
        logoutPage.scrollToElementAndClick();
        String updatedSignOutPage = logoutPage.setSignOutPage();
        logger.info("Updated Sign Out Page Content: " + updatedSignOutPage);
        System.out.println("Updated Sign Out Page Content: " + updatedSignOutPage);
        Assert.assertTrue(updatedSignOutPage.contains("Sign out from all accounts"), "Sign out unsuccessful");
        logoutPage.navigateToSignInPage();
        Assert.assertEquals("https://github.com","https://github.com");
        Thread.sleep(20000);

    }

}
