package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {
    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC011() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(),"",Constant.PASSWORD,"");

        String actualMsg = registerPage.getErrorMessage()+registerPage.getPasswordErrMsg()+registerPage.getPIDErrMsg();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again."+"Invalid password length."+"Invalid ID length.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error msg is not display as expected");
        System.out.println("Test Case ran.");
    }
}