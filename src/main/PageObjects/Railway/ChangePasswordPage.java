package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Localtor
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By lblErrorMessage = By.xpath("//p[@class='message error']");

    //Elements
    protected WebElement getTxtCurrentPassword() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }
    protected WebElement getTxtNewPassword() {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }
    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }
    protected WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }
    protected WebElement getLblErrorMessage() {return Constant.WEBDRIVER.findElement(lblErrorMessage);}

    //Methods
    public String getErrorMessage() {return this.getLblErrorMessage().getText();}
    public void ChangePassword(String currentpassword, String newpassword, String confirmpassword) {
        //Submit login
        this.getTxtCurrentPassword().sendKeys(currentpassword);
        this.getTxtNewPassword().sendKeys(newpassword);
        this.getTxtConfirmPassword().sendKeys(confirmpassword);
        this.getBtnChangePassword().click();
    }
}
