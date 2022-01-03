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
    public boolean logoutText() {
        try {
            if (getLblLogout().equals("Logout")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            check= String.valueOf((e));
        }
        return false;
    }

    public String check;
}