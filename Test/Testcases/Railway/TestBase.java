package Testcases.Railway;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import main.Common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
    @BeforeTest
    public void InitTest(){
        System.out.println("Start Testing");
    }

    @AfterTest
    public void closeTest(){
        System.out.println("End Test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        System.out.println("Reset method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
        System.out.println("End method");
    }
}
