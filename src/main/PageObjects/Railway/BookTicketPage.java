package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {

    //Localtor
    private final By lblBookTicketForm = By.xpath("//legend");
    private final By ddlDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By dblNhaTrang = By.xpath("//select[@name='DepartStation']//option[@value='3']");
    private final By ddlArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By dblSaiGon = By.xpath("//select[@name='ArriveStation']//option[@value='1']");
    private final By ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By dblAmount4 = By.xpath("//select[@name='TicketAmount']//option[@value='4']");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblTicketBooked = By.xpath("//h1");
    private final By tblTicketBooked = By.xpath("//table");

    //Elements
    protected WebElement getLblBookTicketForm() {return Constant.WEBDRIVER.findElement(lblBookTicketForm);}
    protected WebElement getDdlDepartFrom() {return Constant.WEBDRIVER.findElement(ddlDepartFrom);}
    protected WebElement getDblNhaTrang() {return Constant.WEBDRIVER.findElement(dblNhaTrang);}
    protected WebElement getDdlArriveAt() {return Constant.WEBDRIVER.findElement(ddlArriveAt);}
    protected WebElement getDblSaiGon() {return Constant.WEBDRIVER.findElement(dblSaiGon);}
    protected WebElement getDdlTicketAmount() {return Constant.WEBDRIVER.findElement(ddlTicketAmount);}
    protected WebElement getDblAmount4() {return Constant.WEBDRIVER.findElement(dblAmount4);}
    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }
    protected WebElement getLblTicketBooked() {return Constant.WEBDRIVER.findElement(lblTicketBooked);}
    protected WebElement getTblTicketBooked() {return Constant.WEBDRIVER.findElement(tblTicketBooked);}

    //Methods
    public String getBookTicketForm() {return this.getLblBookTicketForm().getText();}
    public String getDepartFrom() {return this.getDblNhaTrang().getText();}
    public String getArriveAt() {return this.getDblSaiGon().getText();}
    public String getTicketBooked() {return this.getLblTicketBooked().getText();}
    public String getTicketBookedTable() {return this.getTblTicketBooked().getText();}
    public String Check;
    public void BookTicket() {
        for (int i = 0; i <= 10; i++) {


        }
    }
}
