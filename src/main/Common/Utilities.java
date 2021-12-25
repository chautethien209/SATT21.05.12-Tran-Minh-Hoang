package main.Common;

import java.io.File;
import java.io.IOException;

public class Utilities {
    public static String getProjectPath() throws IOException {
        System.setProperty("webdriver.chrome.driver"
                ,new File("./src/test/resources/drivers/chromedriver.exe").getCanonicalPath());
        return System.getProperty("user.dir");
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getProjectPath());
    }
}
