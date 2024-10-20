package com.automation;

import java.util.Random;

import org.example.base.TestBase;
import org.example.pages.LoginPage;
import org.example.pages.ProfilePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;


public class ProfileTest extends TestBase {
    private LoginPage loginPage;
    private ProfilePage profilePage;

    @BeforeMethod
    public void setUp() {
        try {
            loginPage = new LoginPage(driver);
            loginPage.clickSignIn();
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.submitSignInButton();
            profilePage = new ProfilePage(driver);
        } catch (Exception e) {
            System.err.println("An error occurred during setup: " + e.getMessage());
            Assert.fail("Setup failed due to: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateUserProfile() {
        try {
            profilePage.iconImgEdit();
            profilePage.setEditYourProfile();
            profilePage.setEditProfile();
            profilePage.clickNameField();
            Random random = new Random();
            int randomNumber = 10000 + random.nextInt(90000);
            String setName = updateName + "-" + randomNumber;

            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

            profilePage.setNameField(setName);
            profilePage.setSaveButton();
            driver.navigate().refresh();
            String updatedName = profilePage.getUpdatedName();
            System.out.println(updatedName);
            System.out.println(setName);
            Assert.assertTrue(updatedName.contains(setName), "Updated name does not match expected value.");

        } catch (Exception e) {
            System.err.println("An error occurred while updating user profile: " + e.getMessage());
            Assert.fail("Profile update test failed due to: " + e.getMessage());
        }
    }
}
