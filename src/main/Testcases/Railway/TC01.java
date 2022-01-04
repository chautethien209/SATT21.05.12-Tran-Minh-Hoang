package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC01 extends TestBase {
    @Test(description = "TC01 - User can login into Railway with valid username and password")
    public void TC001() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.open();
        loginPage.gotoLoginPage();
        loginPage.getLogin(Constant.USENAME, Constant.PASSWORD);

        String actualMsg = homePage.getWelcomeMesage();
        String expectedMsg = "Welcome guest!";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case ran.");
    }
}


