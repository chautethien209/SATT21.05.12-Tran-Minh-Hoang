package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //locator
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblErrorMessage = By.xpath("//p[@class='message error LoginForm']");

    //Element
    protected WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }
    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    protected WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }
    protected WebElement getLblErrorMessage() {return Constant.WEBDRIVER.findElement(lblErrorMessage);}

    //Methods

    public boolean isErrMesDisplay(){
        try{
            if (getLblErrorMessage().isDisplayed())
            {
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return false;
    }

    public String getErrorMessage() {return this.getLblErrorMessage().getText();}

    public void getLogin(String name, String password) {
        //Submit login
        this.getTxtUsername().sendKeys(name);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void getLoginMultipleTimes(String name, String password, int times) {
        //Submit login
        getLogin(name, password);

        for (int i = 1; i < times; i++) {
            this.getTxtUsername().clear();
            getLogin(name, password);
        }
    }
}
