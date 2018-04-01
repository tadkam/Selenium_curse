package section18_waits;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.WaitTypesTest;


public class ExplicitWaitWithUtilityTest {
    private WebDriver driver;
    private String baseUrl;
    WaitTypesTest wt;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        wt = new WaitTypesTest(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
    }

    @Test()
    public void test() throws Exception {
        driver.get(baseUrl);
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement emailField = wt.waitForElement(By.id("user_email"), 3);
        emailField.sendKeys("test");

        wt.clickWhenReady(By.name("commit"),3);

        //driver.findElement(By.id("user_email")).sendKeys("test");
    }

    @AfterEach
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}

