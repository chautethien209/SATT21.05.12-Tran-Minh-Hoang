package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.ChangePasswordPage;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    @Test(description = "TC09 - User can't change password when 'New Password' and 'Confirm Password' are different.")
    public void TC009() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changepassordPage = new ChangePasswordPage();

        homePage.open();
        loginPage.gotoLoginPage();
        loginPage.Login(Constant.USENAME, Constant.PASSWORD);
        changepassordPage.gotoChangePasswordPage();
        changepassordPage.ChangePassword(Constant.PASSWORD,"a123:\"/{}!@$\\","b456:\"/{}!@$\\");

        String actualMsg = changepassordPage.getErrorMessage();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error msg is not display as expected");
        System.out.println("Test Case passed.");
    }
}
