package section23_press;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo1 {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception{
        driver = new FirefoxDriver();
        baseUrl =  "https://letskodeit.teachable.com/p/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testKeyPress() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(@href, 'sign_in')]")).click();

        driver.findElement(By.id("user_email")).sendKeys("test@email.com");
        Thread.sleep(2000);
        driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);

        //driver.findElement(By.id("user_password")).sendKeys("123123");
        //Thread.sleep(2000);
        //driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
    }

    @Test
    public void testTwoKeys() throws Exception {
        driver.get(baseUrl);
        //driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a" );
        //Thread.sleep(2000);

        //driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
       //Thread.sleep(2000);

        String selectAll = Keys.chord(Keys.CONTROL, "a");
        driver.findElement(By.id("openwindow")).sendKeys(selectAll);
        Thread.sleep(4000);
    }


    @Test
    public void testKeyPressWithAction() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(3000);

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        Thread.sleep(3000);
    }


    @After
    public void tearDown() throws Exception {
         driver.quit();

    }

}
