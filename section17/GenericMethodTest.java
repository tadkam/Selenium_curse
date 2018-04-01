package section17;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

class GenericMethodTest {
    private WebDriver driver;
    private String baseUrl;
    private GenericMethod gm;

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        gm = new GenericMethod(driver);



    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);

        //WebElement element = driver.findElement(By.id("name"));
        //WebElement element = gm.getElement("name", "id");
        //element.sendKeys("test");
        //List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
        //int size = elementList.size();
        boolean result1 = gm.isElementPresent("name","id");
        System.out.println("Element is present: " + result1);

        boolean result2 = gm.isElementPresent("name-non present","sid");
        System.out.println("Element is present: " + result2);


    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}