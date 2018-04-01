package Framework_udemy.test.classes;

import Framework_udemy.page.classes.SearchPageFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FrameworkTestCase {
    private WebDriver driver;
    private JavascriptExecutor javascript;
    private String baseUrl;
    SearchPageFactory searchPage;

    @Before
    public void beforeClass() {
        //System.setProperty("webdriver.gecko.driver", "chromedriver.exe");


        driver = new ChromeDriver();
        javascript = (JavascriptExecutor) driver;
        baseUrl = "https://www.expedia.com/";

        searchPage = new SearchPageFactory(driver, javascript);


        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        searchPage.clickFlightsTab();
        Thread.sleep(2000);
        searchPage.setOriginCity("New Yotk");
        Thread.sleep(4000);
        searchPage.setDestinationCity("Chicago");
        searchPage.setDepartureDate("10/28/2015");
        searchPage.setReturnDate("10/31/2015");
    }

    @After
    public void afterClass() {
        driver.quit();
    }


}
