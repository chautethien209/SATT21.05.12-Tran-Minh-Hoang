package main.Testcases.Railway;

import main.Common.Constant;
import main.PageObjects.Railway.ContactPage;
import main.PageObjects.Railway.HomePage;
import main.PageObjects.Railway.LoginPage;
import main.PageObjects.Railway.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC006() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        LogoutPage logoutPage = new LogoutPage();
        ContactPage contactPage = new ContactPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.getLogin(Constant.USENAME, Constant.PASSWORD);
        System.out.println("3. Click on 'Contact' tab");
        contactPage.gotoContactPage();

        System.out.println("4. Click on 'Log out' tab");
        logoutPage.gotoLogoutPage();


        Boolean actualMsg1 = logoutPage.isLogoutDisplay();
        Assert.assertFalse(actualMsg1,"The logout tab still display in the menu");

        Boolean actualMsg2 = homePage.isHomePageDisplay();
        Assert.assertTrue(actualMsg2,"'Home' page is not display ");

        System.out.println("Test Case ran.");
    }
}
