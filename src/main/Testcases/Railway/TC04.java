package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.BookTicketPage;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    @Test(description = "TC04 - User is redirected to Book ticket page after logging in")
    public void TC004() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookticketPage = new BookTicketPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        loginPage.gotoLoginPage();

        System.out.println("3. Login with valid account");
        loginPage.getLogin(Constant.USENAME, Constant.PASSWORD);

        System.out.println("4. Navigate to 'Book ticket' Page");
        bookticketPage.gotoBookTicketPage();

        String actualMsg = bookticketPage.getBookTicketForm();
        String expectedMsg = "Book ticket form";
        Assert.assertEquals(actualMsg, expectedMsg, "Cannot navigate to BookTicketPage");

        System.out.println("Test Case ran.");
    }
}
