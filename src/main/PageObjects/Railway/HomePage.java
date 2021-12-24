package main.PageObjects.Railway;

import main.Common.Constant;

public class HomePage extends GeneralPage {

    //Localtor


    //Elements


    //Methods
    public void open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
}
