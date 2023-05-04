package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UsersTest extends BaseTest{

    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();
    AddUserPage addUserPage = new AddUserPage();
    ViewSystemUsersPage viewSystemUserPage = new ViewSystemUsersPage();
    HomePage homePage = new HomePage();

    @Test
    public void adminShouldAddUserSuccessFully(){

        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        homePage.clickOnAdminTab();
        String expectedMessage =  "System Users";
        String actualMessage = adminPage.systemUsersText();
        assertEquals(actualMessage, expectedMessage);
        adminPage.clickOnAddButton();
        verifyText(driver, By.xpath("//h6[normalize-space()='Add User']"),"Add User");
        addUserPage.selectFromDropDownUserRole("Admin");
        addUserPage.enterEmployeeName("James Bond");
        addUserPage.enterUsername("Prime");
        addUserPage.selectFromDropDownStatus("Disabled");
        addUserPage.enterPassword("Prime12345*");
        addUserPage.confirmPassword("Prime12345*");
        addUserPage.clickOnSaveButton();

       verifyText(driver,By.linkText("Successfully Saved"),"Successfully Saved");

    }
    @Test
    public void searchTheUserCreatedAndVerifyIt(){
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        homePage.clickOnAdminTab();
        String expectedMessage = "System Users";
        verifyText(driver,By.xpath("//h5[normalize-space()='System Users']"),"System Users");
        viewSystemUserPage.enterUsername("John.Smith");
        viewSystemUserPage.selectUserRoleFromDropDown("Admin");
        viewSystemUserPage.enterEmployeeName("John Smith");
        viewSystemUserPage.selectFromDropDownStatus("Enabled");
        viewSystemUserPage.clickOnSearchButton();
        //String expectedMessage1 = "(1) Record Found";
      verifyText(driver,By.xpath("//span[normalize-space()='(1) Record Found']"),"(1) Record Found");

    }
    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(){
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        homePage.clickOnAdminTab();
        String expectedMessage = "System Users";
        String actualMessage = viewSystemUserPage.systemUsersText();
        assertEquals(actualMessage, expectedMessage);
        viewSystemUserPage.enterUsername("John.Smith");
        viewSystemUserPage.selectUserRoleFromDropDown("Admin");
        viewSystemUserPage.enterEmployeeName("John Smith");
        viewSystemUserPage.selectFromDropDownStatus("Enabled");
        viewSystemUserPage.clickOnSearchButton();
        viewSystemUserPage.clickOnCheckbox();
        viewSystemUserPage.clickOnDeleteButton();
        viewSystemUserPage.clickOnYesDelete();
        String expectedMessage1 = "Successfully Deleted";
        String actualMessage1 = viewSystemUserPage.successfullyDeletedText();
        assertEquals(actualMessage1, expectedMessage1);
    }
    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound(){
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        homePage.clickOnAdminTab();
        String expectedMessage = "System Users";
        String actualMessage = viewSystemUserPage.systemUsersText();
        assertEquals(actualMessage, expectedMessage);
        viewSystemUserPage.enterUsername("Prime.Testing");
        viewSystemUserPage.selectUserRoleFromDropDown("Admin");
        viewSystemUserPage.enterEmployeeName("Prime Testing");
        viewSystemUserPage.selectFromDropDownStatus("Disabled");
        viewSystemUserPage.clickOnSearchButton();
    }

}
