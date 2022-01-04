package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC010() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(Constant.USENAME,Constant.PASSWORD,Constant.PASSWORD,registerPage.randomPID());

        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error msg is not display as expected");
        System.out.println("Test Case ran.");
    }
}
