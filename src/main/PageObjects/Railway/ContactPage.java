package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage {

    //Localtor
    private final By lblContactInformation = By.xpath("//div/h1");

    //Elements
    protected WebElement getLblContactInformation() {return Constant.WEBDRIVER.findElement(lblContactInformation);}

    //Methods
    public String getContactInformation() {return this.getLblContactInformation().getText();}
}
