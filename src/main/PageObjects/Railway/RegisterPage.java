package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //locator
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPID = By.id("pid");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By lblSuccessMessage = By.xpath("//div/p");

    //Element
    protected WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }
    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }
    protected WebElement getTxtPID() {return Constant.WEBDRIVER.findElement(txtPID);}
    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }
    protected WebElement getLblSuccessMessage() {return Constant.WEBDRIVER.findElement(lblSuccessMessage);}

    //Methods
    public String getSuccessMessage() {return this.getLblSuccessMessage().getText();}
    public void Register(String email, String password, String ConfirmPassword, String PID) {
        //Submit login
        gotoRegisterPage();
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(ConfirmPassword);
        this.getTxtPID().sendKeys(PID);
        this.getBtnRegister().click();
    }
}
