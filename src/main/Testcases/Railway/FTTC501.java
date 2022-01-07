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

public class FTTC501 extends TestBase {
    @Test(description = "FTTC501 - User can book tickets at a time", dataProvider = "data-provider")
    public void FTTC501(String departStation, String arriveStation, String seatType, String ticketAmount) {
        HomePage homePage = new HomePage();
        BookTicketPage bookticketPage = new BookTicketPage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(), Constant.PASSWORD, Constant.PASSWORD, registerPage.randomPID());

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        loginPage.gotoLoginPage();
        loginPage.getLogin(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        bookticketPage.gotoBookTicketPage();

        System.out.println("4. Select a 'Depart date' from the list");
        bookticketPage.getDepartDate(7);

        System.out.println("5. Select 'Đà Nẵng' for 'Depart from' and 'Quảng Ngãi' for 'Arrive at'");
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);

        System.out.println("6. Select 'Soft bed' for 'Seat type'");
        bookticketPage.getSeatType(seatType);

        System.out.println("7. Select '3' for 'Ticket amount'");
        bookticketPage.getTicketAmount(ticketAmount);

        System.out.println("8. Click on 'Book ticket' button");
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
        JsonObject dataFTTC501 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataFTTC501.get("Depart from").getAsString();
        String arriveStation = dataFTTC501.get("Arrive at").getAsString();
        String seatType = dataFTTC501.get("Seat type").getAsString();
        String ticketAmount = dataFTTC501.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
