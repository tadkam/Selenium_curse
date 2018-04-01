package Section19_JavaScriptExecution;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

class JavaScriptTest {
    private WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        js = (JavascriptExecutor) driver;

        // Maximize the browser's window
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testJavaScriptExecution() throws Exception {
        // Navigation
        // driver.get(baseUrl);
        //---------js.executeScript("window.location = 'https://letskodeit.teachable.com/p/practice';");

        // driver.get() method waits for the page to load completely before going to the next statement
        // Adding Thread.sleep() because we are opening URL using js.executeScript() and it does not wait for the page to load completely
        // If we do not add wait, then Selenium WebDriver will immediately try to find the element and it might have issues with just a little slow connection
       //---------- Thread.sleep(3000);
        // Finding element
        // WebElement textBox = driver.findElement(By.id("name"));
        //--------WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');");
        //----------textBox.sendKeys("test");

        //Size of window
        long height = (Long) js.executeScript("return window.innerHeight;");
        long width = (Long) js.executeScript("return window.innerWidth;");

        System.out.println("High is: " + height);
        System.out.println("Width is: " + width);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }


}