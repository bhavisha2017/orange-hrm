package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By userNameField = By.xpath("//input[@placeholder='Username']");
    By passwordField = By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("//button[normalize-space()='Login']");
    By logoHRForALL = By.xpath("//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']");

    By loginPanelDisplayed = By.xpath("//h5[normalize-space()='Login']");

    public void enterUserName(String username) {
        sendTextToElement(userNameField,username);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField,password);
    }

    public void clickLoginButton() {
        clickOnElement(loginButton);
    }

    public String getLogoHRForALL() {
        return getTextFromElement(logoHRForALL);

    }

    public String loginPanelDisplayed(){
        return getTextFromElement(loginPanelDisplayed);
    }
}
