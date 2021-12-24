package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {

    //Localtor
    private final By lblBookTicketForm = By.xpath("//legend");

    //Elements
    protected WebElement getLblBookTicketForm() {return Constant.WEBDRIVER.findElement(lblBookTicketForm);}

    //Methods
    public String getBookTicketForm() {
        return this.getLblBookTicketForm().getText();
    }
}
