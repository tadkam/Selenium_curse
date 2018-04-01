package section17;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

class GetTextDemoTest {
    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testGetText() throws Exception {
        driver.get(baseUrl);
        //get text
//        WebElement buttonElement = driver.findElement(By.id("opentab"));
//        String elementText = buttonElement.getText();
//        System.out.println("Text on the element is: " + elementText);

        //get Attribute
        WebElement element = driver.findElement(By.id("name"));
        String attributeValue = element.getAttribute("class");
        System.out.println("Value of attribute: " + attributeValue);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
