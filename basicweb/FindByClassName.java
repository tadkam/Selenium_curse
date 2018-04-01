package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;



    public class FindByClassName {

        public static void main(String[] args){
            WebDriver driver;
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            String baseURL = "https://demostore.x-cart.com/";
            driver.manage().window().maximize();
            driver.get(baseURL);

            driver.findElement(By.className("title")).click();

            driver.findElement(By.className("leaf")).click();


        }



    }
