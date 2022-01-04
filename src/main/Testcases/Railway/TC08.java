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
        registerPage.registerAccount(registerPage.randomEmail(),Constant.PASSWORD,Constant.PASSWORD,registerPage.randomPID());
        loginPage.gotoLoginPage();
        loginPage.getLogin(registerPage.autoEmail, Constant.PASSWORD);

        Boolean actualMsg = loginPage.isErrMesDisplay();

        Assert.assertTrue(actualMsg,"Error msg is not display as expected");
        System.out.println("Test Case ran.");
    }
}
