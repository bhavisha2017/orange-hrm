package com.orangehrmlive.demo.testsuite;



import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest{

    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();
    VerifyUsersPage verifyUsersPage = new VerifyUsersPage();
    AddUserPage addUserPage = new AddUserPage();
    HomePage homePage = new HomePage();

    @Test
    public void adminShouldAddUserSuccessFully() throws InterruptedException {

        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        verifyUsersPage.clickAdminLink();
        verifyUsersPage.getSystemUserText();
        verifyUsersPage.clickAddButton();
        verifyUsersPage.AddUser();
        verifyUsersPage.selectAdminRole();
        verifyUsersPage.enterEmp();
        verifyUsersPage.enterUser();
        verifyUsersPage.selectDisableOption();
        verifyUsersPage.enterPass();
        verifyUsersPage.enterConfirmPass();
        verifyUsersPage.clickOnSaveButton();
    }
    @Test
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {

        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
       loginPage.clickLoginButton();
        verifyUsersPage.clickAdminLink();
        verifyUsersPage.getSystemUserText();
        addUserPage.enterUser();
        addUserPage.SelectUserRole();
        addUserPage.SelectStatusDisable();
        addUserPage.ClickSearchButton();
        addUserPage.VerifyResultList();

    }
    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        loginPage.enterUserName("Admin");
       loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        verifyUsersPage.clickAdminLink();
       verifyUsersPage.getSystemUserText();
        addUserPage.enterUser();
        addUserPage.SelectUserRole();
        addUserPage.SelectStatusEnable();
        addUserPage.ClickSearchButton();
        addUserPage.VerifyResultList();
        addUserPage.clickOnCheckbox();
        addUserPage.ClickDeleteButton();
        addUserPage.PopUpClick();
        addUserPage.VerifyMsgCheck();
    }
    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        verifyUsersPage.clickAdminLink();
        verifyUsersPage.getSystemUserText();
        addUserPage.enterUser();
        addUserPage.SelectUserRole();
        addUserPage.SelectStatusDisable();
        addUserPage.SearchButtonDelete();
        addUserPage.VerifyNoRecordFound();
   }

}
