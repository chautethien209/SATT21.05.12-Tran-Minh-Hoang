package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutPage extends GeneralPage {

    //Localtor
    private final By lblLogout = By.xpath("//div[@id='menu']//a/span[text()='Log out']");

    //Elements
    protected WebElement getLblLogout() {
        return Constant.WEBDRIVER.findElement(lblLogout);
    }

    //Methods
    public boolean LogoutText() {
        try {
            if (getLblLogout().equals("Logout")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return false;
    }
    public String Check;
    public void CheckText() {
        gotoContactPage();
        gotoLogoutPage();
        gotoHomePage();
        if (LogoutText() == true) {
            Check = ("Fail");
        } else {
            Check = ("Success");
        }
    }
}