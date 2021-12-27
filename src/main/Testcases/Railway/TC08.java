package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase {
    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC008() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();

        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.Register(RegisterPage.AutoEmail,Constant.PASSWORD,Constant.PASSWORD,RegisterPage.AutoPID);
        loginPage.gotoLoginPage();
        loginPage.Login(RegisterPage.AutoEmail, Constant.PASSWORD);

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error msg is not display as expected");
        System.out.println("Test Case passed.");
    }
}
