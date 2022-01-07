package main.Testcases.Railway;

import com.google.gson.JsonObject;
import main.Common.Constant;
import main.Common.JsonHelper;
import main.Common.Utilities;
import main.PageObjects.Railway.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC503 extends TestBase {
    @Test(description = "FTTC503 - 'User can book ticket with known price", dataProvider = "data-provider")
    public void FTTTC503(String departStation, String arriveStation, String seatType) {
        HomePage homePage = new HomePage();
        BookTicketPage bookticketPage = new BookTicketPage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        TicketPricePage ticketPricePage = new TicketPricePage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(), Constant.PASSWORD, Constant.PASSWORD, registerPage.randomPID());
        loginPage.gotoLoginPage();
        loginPage.getLogin(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Click on 'Ticket price' tab");
        ticketPricePage.gotoTicketPricePage();

        System.out.println("4. Click 'Check Price' in section 'Trains depart from Đà Nẵng' for checking price Đà Nẵng to Huế");
        ticketPricePage.getCheckPrice(departStation, arriveStation);

        System.out.println("5. On Ticket price page, click 'Book ticket' with Hard seat");
        ticketPricePage.getBookTicket(seatType);

        System.out.println("6. Click 'Book ticket' with default information");
        bookticketPage.clickBtnBookTicket();

        String actualMsg1 = bookticketPage.getResultDepart();
        String expectedMsg1 = departStation;
        Assert.assertEquals(actualMsg1, expectedMsg1, "Depart Date info not correct ");

        String actualMsg2 = bookticketPage.getResultArrive();
        String expectedMsg2 = arriveStation;
        Assert.assertEquals(actualMsg2, expectedMsg2, "Depart Date info not correct ");

        String actualMsg3 = bookticketPage.getResultSeat();
        String expectedMsg3 = seatType;
        Assert.assertEquals(actualMsg3, expectedMsg3, "Seat Type info not correct ");

        System.out.println("Test Case ran.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataFTTC503 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataFTTC503.get("Depart Station").getAsString();
        String arriveStation = dataFTTC503.get("Arrive Station").getAsString();
        String seatType = dataFTTC503.get("Seat type").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType}
        };
        return object;
    }
}
