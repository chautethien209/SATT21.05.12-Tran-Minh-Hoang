package main.Testcases.Railway;

import com.google.gson.JsonObject;
import main.Common.Constant;
import main.Common.JsonHelper;
import main.Common.Utilities;
import main.PageObjects.Railway.BookTicketPage;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC17 extends TestBase {
    @Test(description = "TC14(Set3) - User can't book more than 10 tickets", dataProvider = "data-provider")
    public void TC014(String departStation, String arriveStation, String seatType, String ticketAmount10, String ticketAmount1) {
        HomePage homePage = new HomePage();
        BookTicketPage bookticketPage = new BookTicketPage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(), Constant.PASSWORD,Constant.PASSWORD,registerPage.randomPID());

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        loginPage.gotoLoginPage();
        loginPage.getLogin(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        bookticketPage.gotoBookTicketPage();

        System.out.println("4. Book 10 tickets.");
        bookticketPage.getDepartDate(7);
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);
        bookticketPage.getSeatType(seatType);
        bookticketPage.getTicketAmount(ticketAmount10);
        bookticketPage.clickBtnBookTicket();

        System.out.println("5. Click on 'Book ticket' tab again");
        bookticketPage.gotoBookTicketPage();

        System.out.println("6. Book one more ticket.");
        bookticketPage.getDepartDate(7);
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);
        bookticketPage.getSeatType(seatType);
        bookticketPage.getTicketAmount(ticketAmount1);
        bookticketPage.clickBtnBookTicket();

        String excepMsg1 = "There're errors in the form. Please correct the errors and try again.";
        String actualMsg1 = bookticketPage.getErrorMessage();
        Assert.assertEquals(actualMsg1,excepMsg1,"Error msg is not display as expected");

        String actualMsg2 = "You have booked 10 tickets. You can book no more.";
        String expectedMsg2 = bookticketPage.getAmountErrMsg();
        Assert.assertEquals(actualMsg2, expectedMsg2, "Ticket Amount error msg is not display as expected");

        System.out.println("Test Case ran.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC17.get("Depart from").getAsString();
        String arriveStation = dataTC17.get("Arrive at").getAsString();
        String seatType = dataTC17.get("Seat type").getAsString();
        String ticketAmount10 = dataTC17.get("Ticket amount 10").getAsString();
        String ticketAmount1 = dataTC17.get("Ticket amount 1").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount10, ticketAmount1}
        };
        return object;
    }
}
