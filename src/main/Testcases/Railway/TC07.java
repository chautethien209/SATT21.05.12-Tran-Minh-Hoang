package main.Testcases.Railway;

import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test(description = "TC07 - User can create new account")
    public void TC007() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        homePage.open();
        registerPage.Register("test10@gmail.com","hoang20997","hoang20997","123456789");

        String actualMsg = registerPage.getSuccessMessage();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case passed.");
    }
}
