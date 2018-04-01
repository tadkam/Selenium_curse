package section18_waits;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ExpliciWaitTest {
    private WebDriver driver;
    private String baseUrl;


    @BeforeEach
    void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";

        //Maximize the browser's window
        driver.manage().window().maximize();


    }

    @Test()
    public void test() throws Exception {
        driver.get(baseUrl);
        WebElement loginlink = driver.findElement(By.linkText("Login"));
        loginlink.click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));

        emailField.sendKeys("test");
    }



    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}