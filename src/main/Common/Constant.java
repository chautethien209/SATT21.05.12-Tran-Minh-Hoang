package main.Common;

import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.raillog.somee.com/Page/HomePage.cshtml";
    public static final String USENAME = "hoang20997@gmail.com";
    public static final String PASSWORD = "hoang2099";
    public static String date;
    public static void getDate() {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Calendar c = Calendar.getInstance();
        int day = c.get(c.DATE)+7;
        int month = c.get(c.MONTH)+1;
        int year = c.get(c.YEAR);
        date = month+"/"+day+"/"+year;
    }
}
