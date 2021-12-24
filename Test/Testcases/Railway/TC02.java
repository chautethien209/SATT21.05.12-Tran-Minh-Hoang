package Testcases.Railway;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import main.PageObjects.Railway.GeneralPage;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {
    @Test(description = "TC02 - User can't login with blank 'Username' textbox")
    public void TC002() {
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = new LoginPage();

        String actualMsg = loginPage.Login(" ", Constant.PASSWORD).getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error msg is not display as expected");
        System.out.println("Test Case passed.");
    }
}
