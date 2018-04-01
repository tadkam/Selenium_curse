package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class FIndByLinkText {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage().window().maximize();
        driver.get(baseURL);

        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Pract")).click();
    }


}
