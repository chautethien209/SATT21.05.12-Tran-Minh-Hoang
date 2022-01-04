package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.TimeTablePage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC15 extends TestBase{

    @Test(description = "Ticket price page displays with ticket details after clicking on check price link in Train timetable page")
    public void ticketPrice() throws IOException, ParseException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimeTablePage timetablePage = new TimeTablePage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account");
        loginPage.gotoLoginPage();
        loginPage.getLogin(Constant.USENAME,Constant.PASSWORD);
        System.out.println("3. Click on Timetable tab");
        timetablePage.gotoTabTimeTable();
        System.out.println("4. Click on check price link of the route from Đà Nẵng to Sài Gòn");
        timetablePage.getCheckpriceTable();

        String excepMsg = "Ticket price from Đà Nẵng to Sài Gòn";
        String actualMsg = timetablePage.getLblMessage();
        Assert.assertEquals(actualMsg,excepMsg,"Welcome msg is not display as expected");
    }

}

