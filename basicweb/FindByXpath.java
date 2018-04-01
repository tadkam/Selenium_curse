package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FindByXpath {

    public void main (String[] args){
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String baseURL = "http://www.letskodeit.com/";
        driver.manage().window().maximize();
        driver.get(baseURL);


        driver.findElement(By.xpath("//div[@class='style-j4dnywzf']/a[text()='Learn Now']")).click();

        //driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')and contains(@href, 'sing-in")).click();

    }
}
