package Testcases.Railway;

import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC01 extends TestBase {
    @Test (description = "TC01 - User can login into Railway with valid username and password")
    public void TC001() {
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = new LoginPage();
        loginPage.Login("hoang20997@gmail.com", "hoang209");

        String message = loginPage.getWelcomeMesage();
        String actualMsg = message;
        String expectedMsg = "Welcome guest!";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case passed.");
    }


}

