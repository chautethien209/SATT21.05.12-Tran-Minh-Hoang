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
        loginPage.login(Constant.USENAME, Constant.PASSWORD);

        String actualMsg = logoutPage.check;
        String expectedMsg = null;

        Assert.assertEquals(actualMsg, expectedMsg, "'Log out' tab is not disappeared");
        System.out.println("Test Case passed.");
    }
}
