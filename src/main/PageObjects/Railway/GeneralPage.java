package main.PageObjects.Railway;

import main.Common.Constant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;


public class GeneralPage {

    //locator
    private final By tabHome = By.xpath("//div[@id='menu']//a/span[text()='Home']/..");
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href ='/Page/Contact.cshtml']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href = '/Page/BookTicketPage.cshtml']");
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href = '/Account/Login.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href ='/Account/Register.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href ='/Account/ChangePassword.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href = '/Account/Logout']");
    private final By lblWelcomeMesage = By.xpath("//div[@class='account']/strong");

    //Element
    protected WebElement getTabHome() {
        return Constant.WEBDRIVER.findElement(tabHome);
    }
    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }
    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }
    protected WebElement getTabLogin() {return Constant.WEBDRIVER.findElement(tabLogin);}
    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }
    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMesage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMesage);
    }

    //Methods
    public void gotoHomePage(){
        this.getTabHome().click();
    }

    public void gotoContactPage(){
        this.getTabContact().click();
    }

    public void gotoBookTicketPage(){
        this.getTabBookTicket().click();
    }

    public void gotoRegisterPage(){
        this.getTabRegister().click();
    }

    public void gotoLoginPage(){
        this.getTabLogin().click();
    }

    public void gotoChangePasswordPage(){
        this.getTabChangePassword().click();
    }

    public void gotoLogoutPage(){
        this.getTabLogout().click();
    }

    public String getWelcomeMesage(){
        return this.getLblWelcomeMesage().getText();
    }

    public JSONObject callJSON(String url, int indexget) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object data = parser.parse(new FileReader(url));
        JSONArray list = (JSONArray) data;
        return (JSONObject) list.get(indexget);
    }
}