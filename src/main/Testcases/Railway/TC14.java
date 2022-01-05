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

public class TC14 extends TestBase {
    @Test(description = "TC14 - User can book many tickets at a time", dataProvider = "data-provider")
    public void TC014(String departStation, String arriveStation, String seatType, String ticketAmount) {
        HomePage homePage = new HomePage();
        BookTicketPage bookticketPage = new BookTicketPage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(),Constant.PASSWORD,Constant.PASSWORD,registerPage.randomPID());

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        loginPage.gotoLoginPage();
        loginPage.getLogin(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        bookticketPage.gotoBookTicketPage();

        System.out.println("4. Book ticket.");
        bookticketPage.getDepartDate();
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);
        bookticketPage.getSeatType(seatType);
        bookticketPage.getTicketAmount(ticketAmount);
        bookticketPage.clickBtnBookTicket();

        String actualMsg1 = bookticketPage.getMesBookSuccess();
        String expectedMsg1 = "Ticket Booked Successfully!";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Success msg is not display as expected");

        String actualMsg2 = bookticketPage.getResultDate();
        String expectedMsg2 = Constant.date;
        Assert.assertEquals(actualMsg2, expectedMsg2, "Depart Date info not correct ");

        String actualMsg3 = bookticketPage.getResultDepart();
        String expectedMsg3 = departStation;
        Assert.assertEquals(actualMsg3, expectedMsg3, "Depart Station info not correct ");

        String actualMsg4 = bookticketPage.getResultArrive();
        String expectedMsg4 = arriveStation;
        Assert.assertEquals(actualMsg4, expectedMsg4, "Arrive Station info not correct ");

        String actualMsg5 = bookticketPage.getResultSeat();
        String expectedMsg5 = seatType;
        Assert.assertEquals(actualMsg5, expectedMsg5, "Seat Type info not correct ");

        String actualMsg6 = bookticketPage.getResultAmount();
        String expectedMsg6 = ticketAmount;
        Assert.assertEquals(actualMsg6, expectedMsg6, "Ticket Amount info not correct ");

        System.out.println("Test Case ran.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC14.get("Depart from").getAsString();
        String arriveStation = dataTC14.get("Arrive at").getAsString();
        String seatType = dataTC14.get("Seat type").getAsString();
        String ticketAmount = dataTC14.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
