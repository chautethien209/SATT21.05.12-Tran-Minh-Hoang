package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.ChangePasswordPage;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    @Test(description = "TC09 - User can't change password when 'New Password' and 'Confirm Password' are different.")
    public void TC009() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changepassordPage = new ChangePasswordPage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(),Constant.PASSWORD,Constant.PASSWORD,registerPage.randomPID());

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.getLogin(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Click on 'Change Password' tab");
        changepassordPage.gotoChangePasswordPage();

        System.out.println("4. Enter valid information into 'Current Password' textbox but enter 'a123:\"/{}!@$\\' into 'New Password' textbox and 'b456:\"/{}!@$\\' into 'Confirm Password' textbox.");
        changepassordPage.changePassword(Constant.PASSWORD,"a123:\"/{}!@$\\","b456:\"/{}!@$\\");

        String actualMsg1 = changepassordPage.getErrorMessage();
        String expectedMsg1 = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error msg is not display as expected");

        String actualMsg2 = changepassordPage.getConfirmPassErrMsg();
        String expectedMsg2 = "The password confirmation does not match the new password.";
        Assert.assertEquals(actualMsg2, expectedMsg2, "ConfirmPassword error msg is not display as expected");

        System.out.println("Test Case ran.");
    }
}
