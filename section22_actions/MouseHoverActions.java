package section22_actions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHoverActions {
    private WebDriver driver;
    private String baseUrl;
    JavascriptExecutor jse;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        jse = (JavascriptExecutor)driver;

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test()
    public void testMouseHoverActions() throws Exception {
        driver.get(baseUrl);
        jse.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(2000);

        WebElement mainElement = driver.findElement(By.id("mousehover"));

        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        Thread.sleep(2000);

        WebElement subElement = driver.findElement(By.xpath("//div[@class = 'mouse-hover-content']//a[text()='Top']"));
        action.moveToElement(subElement).click().perform();
    }






    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
