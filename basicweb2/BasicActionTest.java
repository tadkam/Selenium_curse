package basicweb2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

class BasicActionTest {

    WebDriver driver;
    String baseURL;


    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public void test(){
        driver.get(baseURL);
        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        System.out.println("Click on login");

        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("test@email.com");
        System.out.println("Send keys to user name field");
        driver.findElement(By.id("user_password")).sendKeys("test");
        System.out.println("Send keys to password field");
        driver.findElement(By.id("user_email")).clear();
        System.out.println("Clearing user name field");
    }

    @AfterEach
    void tearDown() {

        //driver.quit();


    }
}