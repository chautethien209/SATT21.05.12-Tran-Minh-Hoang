package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {
    //Localtor

    //Dynamic Locator
    String lnkCheckPrice = "//li[contains(text(),'%s to %s')]/../following-sibling::td/a[contains(@href,'TicketPricePage')]";
    String lnkBookTicket = "//td[text()='%s']/following-sibling::td/a[contains(@href,'BookTicketPage')]";

    //Elements
    protected WebElement getLnkCheckPrice(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkCheckPrice, departStation, arriveStation)));
    }
    protected WebElement getLnkBookTicket(String seatType) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkBookTicket, seatType)));
    }

    //Methods
    public void getCheckPrice(String departStation, String arriveStation) {
        Constant.getWait(20);
        this.getLnkCheckPrice(departStation, arriveStation).click();
    }

    public void getBookTicket(String seatType) {
        Constant.getWait(20);
        this.getLnkBookTicket(seatType).click();
    }
}
