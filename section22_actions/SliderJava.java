package section22_actions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SliderJava  {
    protected WebDriver driver;
    protected String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl =  "http://jqueryui.com/slider/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void  testDragAndDrop() throws Exception {
        driver.get(baseUrl);
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span"));

        Actions action = new Actions(driver);
        action.dragAndDropBy(element,100,0).perform();


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }


}
