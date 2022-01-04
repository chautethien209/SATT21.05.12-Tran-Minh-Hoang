package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.BookTicketPage;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.RegisterPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC14 extends TestBase {
    @Test(description = "TC14 - User can book many tickets at a time")
    public void TC014() throws IOException, ParseException, InterruptedException {
        HomePage homePage = new HomePage();
        BookTicketPage bookticketPage = new BookTicketPage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account ");
        loginPage.gotoLoginPage();
        loginPage.getLogin(Constant.USENAME, Constant.PASSWORD);
        System.out.println("3. Click on Book ticket tab");
        bookticketPage.gotoBookTicketPage();
        System.out.println("4. Book ticket.");
        bookticketPage.goBookTicket();

        String actualMsg = bookticketPage.getMesBookSuccess();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Success msg is not display as expected");
        System.out.println("Test Case ran.");
    }
}
