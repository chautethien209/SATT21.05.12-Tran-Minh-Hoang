package main.Testcases.Railway;

import com.google.gson.JsonObject;
import main.Common.Constant;
import main.Common.JsonHelper;
import main.Common.Utilities;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.RegisterPage;
import main.PageObjects.Railway.TimeTablePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC15 extends TestBase{
    @Test(description = "Ticket price page displays with ticket details after clicking on check price link in Train timetable page", dataProvider = "data-provider")
    public void TC15(String departStation, String arriveStation, String hS, String sS, String sSC, String hB, String sB, String sBC) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimeTablePage timetablePage = new TimeTablePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegisterPage();
        registerPage.registerAccount(registerPage.randomEmail(),Constant.PASSWORD,Constant.PASSWORD,registerPage.randomPID());

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account");
        loginPage.gotoLoginPage();
        loginPage.getLogin(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Click on 'Timetable' tab");
        timetablePage.gotoTabTimeTable();

        System.out.println("4. Click on check price link of the route from Đà Nẵng to Sài Gòn");
        timetablePage.checkPrice(departStation, arriveStation);

        String excepMsg1 = "Ticket price from Đà Nẵng to Sài Gòn";
        String actualMsg1 = timetablePage.getLblMessage();
        Assert.assertEquals(actualMsg1,excepMsg1,"Depart Station and/or Arrive Station are not correct");

        String actualMsg2 = timetablePage.getSeatTypePrice("HS");
        String expectedMsg2 = hS;
        Assert.assertEquals(actualMsg2, expectedMsg2, "Hard seat Price is not correct ");

        String actualMsg3 = timetablePage.getSeatTypePrice("SS");
        String expectedMsg3 = sS;
        Assert.assertEquals(actualMsg3, expectedMsg3, "Soft seat Price is not correct ");

        String actualMsg4 = timetablePage.getSeatTypePrice("SSC");
        String expectedMsg4 = sSC;
        Assert.assertEquals(actualMsg4, expectedMsg4, "Soft seat with air conditioner Price is not correct ");

        String actualMsg5 = timetablePage.getSeatTypePrice("HB");
        String expectedMsg5 = hB;
        Assert.assertEquals(actualMsg5, expectedMsg5, "Hard bed Price is not correct ");

        String actualMsg6 = timetablePage.getSeatTypePrice("SB");
        String expectedMsg6 = sB;
        Assert.assertEquals(actualMsg6, expectedMsg6, "Soft bed Price is not correct ");

        String actualMsg7 = timetablePage.getSeatTypePrice("SBC");
        String expectedMsg7 = sBC;
        Assert.assertEquals(actualMsg7, expectedMsg7, "Soft bed with air conditioner Price is not correct ");

        System.out.println("Test Case ran.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC15 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC15.get("Depart Station").getAsString();
        String arriveStation = dataTC15.get("Arrive Station").getAsString();
        String hS = dataTC15.get("HS").getAsString();
        String sS = dataTC15.get("SS").getAsString();
        String sSC = dataTC15.get("SSC").getAsString();
        String hB = dataTC15.get("HB").getAsString();
        String sB = dataTC15.get("SB").getAsString();
        String sBC = dataTC15.get("SBC").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, hS, sS, sSC, hB, sB, sBC}
        };
        return object;
    }
}

