package main.Testcases.Railway;

import com.google.gson.JsonObject;
import main.Common.Constant;
import main.Common.JsonHelper;
import main.Common.Utilities;
import main.PageObjects.Railway.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    @Test(description = "TC16 - User can cancel a ticket", dataProvider = "data-provider")
    public void TC016(String departStation, String arriveStation, String seatType, String ticketAmount, String noTicket) {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookticketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(),Constant.PASSWORD,Constant.PASSWORD,registerPage.randomPID());

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account");
        loginPage.gotoLoginPage();
        loginPage.getLogin(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Book a ticket.");
        bookticketPage.gotoBookTicketPage();
        bookticketPage.getDepartDate();
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);
        bookticketPage.getSeatType(seatType);
        bookticketPage.getTicketAmount(ticketAmount);
        bookticketPage.clickBtnBookTicket();

        System.out.println("4. Click on 'My ticket' tab");
        myTicketPage.gotoMyTicketPage();

        System.out.println("5. Cancel a ticket");
        myTicketPage.getCancel(noTicket, departStation, arriveStation);

        Assert.assertFalse(myTicketPage.isCancelDisplay(noTicket, departStation, arriveStation), "Cancel button still display");

        System.out.println("Test Case ran.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC16 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC16.get("Depart from").getAsString();
        String arriveStation = dataTC16.get("Arrive at").getAsString();
        String seatType = dataTC16.get("Seat type").getAsString();
        String ticketAmount = dataTC16.get("Ticket amount").getAsString();
        String noTicket = dataTC16.get("Number of Ticket").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount, noTicket}
        };
        return object;
    }
}
