package main.PageObjects.Railway;

import main.Common.Constant;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BookTicketPage extends GeneralPage {

    //Localtor
    private final By lblBookTicketForm = By.xpath("//legend");
    private final By ddlDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By dblNhaTrang = By.xpath("//select[@name ='DepartStation']//option[text()='Nha Trang']");
    private final By ddlArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By dblSaiGon = By.xpath("//select[@name ='ArriveStation']//option[text()='Sài Gòn']");
    private final By ddlSeatType = By.xpath("//select[@name='SeatType']");
    private final By dblSoftSeat = By.xpath("//select[@name ='SeatType']//option[text()='Soft seat']");
    private final By ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By dblAmount5 = By.xpath("//select[@name='TicketAmount']//option[text()='5']");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblMessageBookSuccess = By.xpath("//h1");
    private final By tblTicketBooked = By.xpath("//table");

    //Elements
    protected WebElement getLblBookTicketForm() {return Constant.WEBDRIVER.findElement(lblBookTicketForm);}
    protected WebElement getDdlDepartFrom() {return Constant.WEBDRIVER.findElement(ddlDepartFrom);}
    protected WebElement getDblNhaTrang() {return Constant.WEBDRIVER.findElement(dblNhaTrang);}
    protected WebElement getDdlArriveAt() {return Constant.WEBDRIVER.findElement(ddlArriveAt);}
    protected WebElement getDblSaiGon() {return Constant.WEBDRIVER.findElement(dblSaiGon);}
    protected WebElement getDdlSeatType(){return Constant.WEBDRIVER.findElement(ddlSeatType);}
    protected WebElement getDblSoftSeat(){return Constant.WEBDRIVER.findElement(dblSoftSeat);}
    protected WebElement getDdlTicketAmount() {return Constant.WEBDRIVER.findElement(ddlTicketAmount);}
    protected WebElement getDblAmount5() {return Constant.WEBDRIVER.findElement(dblAmount5);}
    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }
    protected WebElement getLblMessageBookSuccess() {return Constant.WEBDRIVER.findElement(lblMessageBookSuccess);}
    protected WebElement getTblTicketBooked() {return Constant.WEBDRIVER.findElement(tblTicketBooked);}

    //Methods
    public String getBookTicketForm() {return this.getLblBookTicketForm().getText();}

    public String getMesBookSuccess() {return this.getLblMessageBookSuccess().getText();}

    public String getTicketBookedTable() {return this.getTblTicketBooked().getText();}

    public String getNhaTrang() {return this.getDblNhaTrang().getText();}

    public String getSaiGon() {return this.getDblNhaTrang().getText();}

    public String getSoftSeat() {return this.getDblSoftSeat().getText();}

    public String get5Ticket() {return this.getDblAmount5().getText();}


    public void getDepartFrom() throws IOException, ParseException {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JSONObject jsonObject = callJSON("src/main/Testcases/Railway/data.json", 0);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("TC14");
        String localTestDepart = (String) jsonObject1.get("Depart from");

        if (getNhaTrang().equals(localTestDepart)) {
            System.out.println("getDepartFrom pass");
            this.getDblNhaTrang().click();
        }
    }

    public void getArriveAt() throws IOException, ParseException {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JSONObject jsonObject = callJSON("src/main/Testcases/Railway/data.json", 0);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("TC14");
        String localTestArrive = (String) jsonObject1.get("Arrive at");
        if (getSaiGon().equals(localTestArrive)) {
            System.out.println("getArriveAt pass");
            this.getDblSaiGon().click();
        }
    }

    public void getSeatType() throws IOException, ParseException {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JSONObject jsonObject = callJSON("src/main/Testcases/Railway/data.json", 0);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("TC14");
        String localTestSeat = (String) jsonObject1.get("Seat type");
        if (getSoftSeat().equals(localTestSeat)) {
            System.out.println("getSeatType pass");
            this.getDblSoftSeat().click();
        }
    }

    public void getTicketAmount() throws IOException, ParseException {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JSONObject jsonObject = callJSON("src/main/Testcases/Railway/data.json", 0);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("TC14");
        String localTestAmount = (String) jsonObject1.get("Ticket amount");
        if (get5Ticket().equals(localTestAmount)) {
            System.out.println("getSeatType pass");
            this.getDblAmount5().click();
        }
    }

    public void goBookTicket() throws IOException, ParseException, InterruptedException {
        getDepartFrom();
        getArriveAt();
        getSeatType();
        getTicketAmount();
        this.getBtnBookTicket().click();
    }
}
