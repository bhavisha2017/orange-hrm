package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.DashBoardPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    @Test
    public void verifyUserShouldLoginSuccessFully() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        String expectedMessage = "Dashboard";
        String actualMessage = dashBoardPage.getDashboardText();
        assertEquals(actualMessage, expectedMessage);

    }
    @Test
        public void VerifyThatTheLogoDisplayOnLoginPage(){

        verifyText(driver,By.xpath("//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']") , "orangehrm-logo");
        }
        @Test
        public void VerifyUserShouldLogOutSuccessFully(){
            loginPage.enterUserName("Admin");
            loginPage.enterPassword("admin123");
            loginPage.clickLoginButton();
            dashBoardPage.clickOnUserProfileLogo();
            dashBoardPage.mouseHooverOnLogoutAndClick();
            String expectedMessage = "Login";
            String actualMessage = loginPage.loginPanelDisplayed();
            assertEquals(actualMessage, expectedMessage);
         verifyText(driver,By.xpath("//h5[normalize-space()='Login']"),"Login Panel");
        }
    }
