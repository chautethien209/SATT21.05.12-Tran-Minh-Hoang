package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test(description = "TC07 - User can create new account")
    public void TC007() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(),Constant.PASSWORD,Constant.PASSWORD, registerPage.randomPID());

        String actualMsg = registerPage.getSuccessMessage();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg, expectedMsg, "Success msg is not display as expected");
        System.out.println("Test Case ran.");
    }
}
