package main.PageObjects.Railway;

import main.Common.Constant;
import org.apache.commons.lang3.RandomStringUtils;
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
    private final By lblErrorMessage = By.xpath("//p[@class='message error']");
    private final By lblPasswordErrMsg = By.xpath("//li/label[@for='password']/following-sibling::label");
    private final By lblPIDErrMsg = By.xpath("//li/label[@for='pid']/following-sibling::label");

    //Element
    protected WebElement getTxtEmail() {return Constant.WEBDRIVER.findElement(txtEmail);}
    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }
    protected WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }
    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }
    protected WebElement getLblSuccessMessage() {
        return Constant.WEBDRIVER.findElement(lblSuccessMessage);
    }
    protected WebElement getLblErrorMessage() {return Constant.WEBDRIVER.findElement(lblErrorMessage);}
    protected WebElement getLblPasswordErrMsg() {return Constant.WEBDRIVER.findElement(lblPasswordErrMsg);}
    protected WebElement getLblPIDErrMsg() {return Constant.WEBDRIVER.findElement(lblPIDErrMsg);}

    //Methods
    public String getSuccessMessage() {return this.getLblSuccessMessage().getText();}

    public String getErrorMessage() {return this.getLblErrorMessage().getText();}

    public String getPasswordErrMsg() {return this.getLblPasswordErrMsg().getText();}

    public String getPIDErrMsg() {return this.getLblPIDErrMsg().getText();}

    public void registerAccount(String email, String password, String ConfirmPassword, String PID) {
        //Submit register
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(ConfirmPassword);
        this.getTxtPID().sendKeys(PID);
        this.getBtnRegister().click();
    }

    public String autoEmail;

    public String randomEmail() {
        String generateEmail = RandomStringUtils.randomAlphabetic(6);
        autoEmail = generateEmail + "@gmail.com";
        return autoEmail;
    }

    public String randomPID() {
        String AutoPID = RandomStringUtils.randomNumeric(8);
        return AutoPID;
    }
}
