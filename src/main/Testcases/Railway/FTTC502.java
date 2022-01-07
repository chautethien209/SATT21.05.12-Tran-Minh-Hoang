package main.Testcases.Railway;

import com.google.gson.JsonObject;
import main.Common.Constant;
import main.Common.JsonHelper;
import main.Common.Utilities;
import main.PageObjects.Railway.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC502 extends TestBase {
    @Test(description = "FTTC502 - 'Manage ticket' displays remaining available number of booking", dataProvider = "data-provider")
    public void FTTTC502(String departStation, String arriveStation, String seatType, String ticketAmount) {
        HomePage homePage = new HomePage();
        BookTicketPage bookticketPage = new BookTicketPage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(), Constant.PASSWORD, Constant.PASSWORD, registerPage.randomPID());

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        loginPage.gotoLoginPage();
        loginPage.getLogin(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Book 4 tickets with different 'Depart Dates'");
        bookticketPage.bookTicket(6, departStation, arriveStation, seatType, ticketAmount);
        bookticketPage.bookTicket(7, departStation, arriveStation, seatType, ticketAmount);
        bookticketPage.bookTicket(8, departStation, arriveStation, seatType, ticketAmount);
        bookticketPage.bookTicket(9, departStation, arriveStation, seatType, ticketAmount);

        System.out.println("4. Click on 'My ticket' tab");
        myTicketPage.gotoMyTicketPage();

        Boolean actualMsg1 = myTicketPage.isTableDisplay();
        Assert.assertTrue(actualMsg1,"Table Manage Tickets is not display as expected");

        String actualMsg2 = myTicketPage.getNoteAmount();
        String expectedMsg2 = "You currently book 4 tickets, you can book 6 more.";
        Assert.assertEquals(actualMsg2, expectedMsg2, "Depart Date info not correct ");

        System.out.println("Test Case ran.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataFTTC502 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataFTTC502.get("Depart from").getAsString();
        String arriveStation = dataFTTC502.get("Arrive at").getAsString();
        String seatType = dataFTTC502.get("Seat type").getAsString();
        String ticketAmount = dataFTTC502.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
