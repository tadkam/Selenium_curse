package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriver {

    public static void main(String[] args){
        WebDriver driver;
        System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        String baseURL ="http://www.google.com";

        driver.get(baseURL);
        //driver.quit();
    }
}




