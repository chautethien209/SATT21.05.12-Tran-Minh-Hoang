package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //locator
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='login']");
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

    @Override
    public String getWelcomeMesage() {
        return super.getWelcomeMesage();
    }

    public String getErrorMessage() {return this.getLblErrorMessage().getText();}

    public void login(String name, String password) {
        //Submit login
        this.getTxtUsername().sendKeys(name);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void loginMultipleTimes(String name, String password, int times) {
        //Submit login
        login(name, password);

        for (int i = 1; i < times; i++) {
            this.getTxtUsername().clear();
            login(name, password);
        }
    }
}
