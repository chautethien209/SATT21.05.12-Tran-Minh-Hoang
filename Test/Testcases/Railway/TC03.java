package Testcases.Railway;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    @Test(description = "TC03 - User cannot log into Railway with invalid password ")
    public void TC003() {
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = new LoginPage();

        String actualMsg = loginPage.Login(Constant.USENAME, "hoang20997").getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error msg is not display as expected");
        System.out.println("Test Case passed.");
    }
}
