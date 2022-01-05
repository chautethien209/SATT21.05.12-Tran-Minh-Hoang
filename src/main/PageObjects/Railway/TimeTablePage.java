package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TimeTablePage extends GeneralPage {
    //Locator
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href ='TrainTimeListPage.cshtml']");
    private final By lblMessage = By.xpath("//tr[@class='TableSmallHeader']");

    //Dynamic Locator
    String lnkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";
    String lblPrice = "//th[contains(text(), 'Price (VND)')]/../td[count(//td[text()='%s']/preceding-sibling::td)+1]";

    //Element
    protected WebElement getTabTimetable() {return Constant.WEBDRIVER.findElement(tabTimetable);}
    protected WebElement getlblMessage(){
        return Constant.WEBDRIVER.findElement(lblMessage);
    }
    protected WebElement getLnkCheckPrice(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkCheckPrice, departStation, arriveStation)));
    }
    protected WebElement getLblPrice(String seatType) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lblPrice, seatType)));
    }

    //Methods
    public String getLblMessage(){
        return this.getlblMessage().getText();
    }

    public void gotoTabTimeTable() {
        this.getTabTimetable().click();
    }

    public void checkPrice(String departStation, String arriveStation) {
            Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            this.getLnkCheckPrice(departStation, arriveStation).click();
    }

    public String getSeatTypePrice(String seatType) {return this.getLblPrice(seatType).getText(); }
}
