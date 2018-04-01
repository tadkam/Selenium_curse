package basicweb2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

class ElementStateTest {
    WebDriver driver;
    String baseUrl;


    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test(){
        WebElement e1 = driver.findElement(By.id("lst-ib"));
        System.out.println("E1 is Enabled? " + e1.isEnabled());

        e1.sendKeys("letskodeit");
    }




    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}