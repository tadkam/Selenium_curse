package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

    public static void main(String[] args){
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "../Drivery/chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL ="http://www.google.com";

        driver.get(baseURL);
        driver.quit();
    }
}
