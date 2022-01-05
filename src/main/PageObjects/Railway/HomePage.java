package main.PageObjects.Railway;

import main.Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    //Localtor
    private final By lblHome = By.xpath("//h1");

    //Elements
    protected WebElement getLblHome() {
        return Constant.WEBDRIVER.findElement(lblHome);
    }

    //Methods
    public void open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public boolean isHomePageDisplay(){
            if (getLblHome().isDisplayed())
            {
                return true;
            }else{
                return false;
            }
    }
}
