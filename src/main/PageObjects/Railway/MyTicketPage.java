package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    //locator

    ////Dynamic Locator
    String btnCancel = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";

    //Elements
    protected WebElement getBtnCancel(String id, String departStation, String arriveStation) {return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancel, id, departStation, arriveStation)));}

    //method
    public void getCancel(String id, String departStation,String arriveStation){
        this.getBtnCancel(id, departStation, arriveStation).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public boolean isCancelDisplay(String id, String departStation,String arriveStation){
        try{
            return this.getBtnCancel(id, departStation, arriveStation).isDisplayed();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return false;
    }
}
