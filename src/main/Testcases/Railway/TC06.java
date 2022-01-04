package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC006() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        LogoutPage logoutPage = new LogoutPage();

        homePage.open();
        loginPage.gotoLoginPage();
        loginPage.getLogin(Constant.USENAME, Constant.PASSWORD);

        Boolean actualMsg = logoutPage.isGoToLogoutPage();

        Assert.assertTrue(actualMsg,"Logout tab is display in menu");
        System.out.println("Test Case ran.");
    }
}
