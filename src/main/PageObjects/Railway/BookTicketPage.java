package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {

    //Localtor
    private final By lblBookTicketForm = By.xpath("//legend");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblMessageBookSuccess = By.xpath("//h1");
    private final By lblResultDate = By.xpath("//td[count(//th[text()='Depart Date']/preceding-sibling::th)+1]");
    private final By lblResultDepart = By.xpath("//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By lblResultArrive = By.xpath("//td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private final By lblResultSeat = By.xpath("//td[count(//th[text()='Seat Type']/preceding-sibling::th)+1]");
    private final By lblResultAmount = By.xpath("//td[count(//th[text()='Amount']/preceding-sibling::th)+1]");
    private final By lblErrorMessage = By.xpath("//p[@class='message error']");
    private final By lblAmountErrMsg = By.xpath("//label[@class='validation-error']");

    //Dynamic Locator
    String dblDepartDate="//div[@id='content']/div/form//select[@name ='Date']//option[text()='%s']";
    String dblDepartFrom = "//select[@name ='DepartStation']//option[text()='%s']";
    String dblArriveAt = "//select[@name ='ArriveStation']//option[text()='%s']";
    String dblSeatType = "//select[@name ='SeatType']//option[text()='%s']";
    String dblTicketAmount = "//select[@name='TicketAmount']//option[text()='%s']";


    //Elements
    protected WebElement getLblBookTicketForm() {return Constant.WEBDRIVER.findElement(lblBookTicketForm);}
    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }
    protected WebElement getLblMessageBookSuccess() {return Constant.WEBDRIVER.findElement(lblMessageBookSuccess);}
    protected WebElement getDblDepartDate(String departDate){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblDepartDate, departDate)));
    }
    protected WebElement getDblDepartFrom(String departFrom) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblDepartFrom, departFrom)));
    }
    protected WebElement getDblArriveAt(String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblArriveAt, arriveAt)));
    }
    protected WebElement getDblSeatType(String seatType) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblSeatType, seatType)));
    }
    protected WebElement getDblTicketAmount(String ticketAmount) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblTicketAmount, ticketAmount)));
    }
    protected WebElement getLblResultDate() {return Constant.WEBDRIVER.findElement(lblResultDate);}
    protected WebElement getLblResultDepart() {return Constant.WEBDRIVER.findElement(lblResultDepart);}
    protected WebElement getLblResultArrive() {return Constant.WEBDRIVER.findElement(lblResultArrive);}
    protected WebElement getLblResultSeat() {return Constant.WEBDRIVER.findElement(lblResultSeat);}
    protected WebElement getLblResultAmount() {return Constant.WEBDRIVER.findElement(lblResultAmount);}
    protected WebElement getLblErrorMessage() {return Constant.WEBDRIVER.findElement(lblErrorMessage);}
    protected WebElement getLblAmountErrMsg() {return Constant.WEBDRIVER.findElement(lblAmountErrMsg);}

    //Methods
    public String getBookTicketForm() {return this.getLblBookTicketForm().getText();}

    public String getMesBookSuccess() {return this.getLblMessageBookSuccess().getText();}

    public void getDepartDate(int day) {
        Constant.getDate(day);
        this.getDblDepartDate(Constant.date).click();
    }

    public void getDepartFrom(String departFrom) {
        Constant.getWait(20);
        this.getDblDepartFrom(departFrom).click();
    }

    public void getArriveAt(String arrivalAt) {
        Constant.getWait(20);
        this.getDblArriveAt(arrivalAt).click();
    }

    public void getSeatType(String seatType) {
        Constant.getWait(20);
        this.getDblSeatType(seatType).click();
    }

    public void getTicketAmount(String ticketAmount) {
        Constant.getWait(20);
        this.getDblTicketAmount(ticketAmount).click();
    }

    public void clickBtnBookTicket() {
        Constant.getWait(20);
        this.getBtnBookTicket().click();
    }

    public void bookTicket(int day, String departFrom, String arrivalAt, String seatType, String ticketAmount) {
        gotoBookTicketPage();
        getDepartDate(day);
        getDepartFrom(departFrom);
        getArriveAt(arrivalAt);
        getSeatType(seatType);
        getTicketAmount(ticketAmount);
        clickBtnBookTicket();
    }

    public String getResultDate() {return this.getLblResultDate().getText();}

    public String getResultDepart() {return this.getLblResultDepart().getText();}

    public String getResultArrive() {return this.getLblResultArrive().getText();}

    public String getResultSeat() {return this.getLblResultSeat().getText();}

    public String getResultAmount() {return this.getLblResultAmount().getText();}

    public String getErrorMessage() {return this.getLblErrorMessage().getText();}

    public String getAmountErrMsg() {return this.getLblAmountErrMsg().getText();}
}
