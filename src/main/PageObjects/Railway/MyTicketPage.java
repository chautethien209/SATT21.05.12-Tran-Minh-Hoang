package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    //locator
    private final By tblManageTickets = By.xpath("//table");
    private final By lblNoteAmount = By.xpath("//li[contains(text(), 'currently')]");

    ////Dynamic Locator
    String btnCancel = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";

    //Elements
    protected WebElement getBtnCancel(String id, String departStation, String arriveStation) {return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancel, id, departStation, arriveStation)));}
    protected WebElement getTblManageTickets() {
        return Constant.WEBDRIVER.findElement(tblManageTickets);
    }
    protected WebElement getLblNoteAmount() {
        return Constant.WEBDRIVER.findElement(lblNoteAmount);
    }

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

    public boolean isTableDisplay(){
        try{
            return this.getTblManageTickets().isDisplayed();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return true;
    }

    public String getNoteAmount() {return this.getLblNoteAmount().getText();}
}
