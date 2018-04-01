package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;



public class FindByCssSelector {

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage().window().maximize();
        driver.get(baseURL);

        driver.findElement(By.cssSelector("fieldset>input[value='Alert']")).click();

        //driver.findElement(By.className("leaf")).click();


    }


}
