package Testcases.Railway;

import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC006() {
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = new LoginPage();

        String actualMsg = loginPage.Login("hoang20997@gmail.com", "hoang209").gotoContactPage().gotoLogoutPage().getLogout();
        String expectedMsg = "";

        Assert.assertEquals(actualMsg, expectedMsg, "Cannot navigate to BookTicketPage");
        System.out.println("Test Case passed.");
    }

}
