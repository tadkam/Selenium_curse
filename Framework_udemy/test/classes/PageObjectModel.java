package Framework_udemy.test.classes;

import Framework_udemy.page.classes.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PageObjectModel {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://expedia.com";

        //Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        SearchPage.fillOriginTextBox(driver, "New York");
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        SearchPage.departureDateTextBox(driver).sendKeys("12/25/2-14");
        SearchPage.returnDateTextBox(driver).sendKeys("12/31/2014");
        Thread.sleep(2000);
        SearchPage.clickOnSearchButton(driver);
        Thread.sleep(3000);

    }


    @After
    public void tearDown() throws Exception{
        driver.quit();

    }
}
