package Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    @Test(description = "TC04 - User is redirected to Book ticket page after logging in")
    public void TC004() {
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = new LoginPage();

        String actualMsg = loginPage.Login(Constant.USENAME, Constant.PASSWORD).gotoBookTicketPage().getBookTicketForm();
        String expectedMsg = "Book ticket form";

        Assert.assertEquals(actualMsg, expectedMsg, "Cannot navigate to BookTicketPage");
        System.out.println("Test Case passed.");
    }
}
