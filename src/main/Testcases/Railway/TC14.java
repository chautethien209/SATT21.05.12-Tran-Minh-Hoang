package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.BookTicketPage;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    @Test(description = "TC14 - User can book many tickets at a time")
    public void TC014() {
        HomePage homePage = new HomePage();
        BookTicketPage bookticketPage = new BookTicketPage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();

        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(), Constant.PASSWORD,Constant.PASSWORD,registerPage.randomPID());
        loginPage.gotoLoginPage();
        loginPage.login(registerPage.autoEmail, Constant.PASSWORD);
        bookticketPage.gotoBookTicketPage();
        bookticketPage.BookTicket("Nha Trang","Sài Gòn","Hard seat","4");

        String actualMsg = bookticketPage.getTicketBooked();
        String expectedMsg = "Ticket booked successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Success msg is not display as expected");
        System.out.println("Test Case passed.");
    }
}
