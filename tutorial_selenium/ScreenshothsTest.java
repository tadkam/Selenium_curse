package tutorial_selenium;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

class ScreenshothsTest {
    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testScreenshots() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("package-origin-hp-package")).click();

        // Find Elements
        WebElement flight_origin = driver.findElement(By.id("package-origin-hp-package"));
        WebElement flight_destination = driver.findElement(By.id("package-destination-hp-package"));
        WebElement departure_date = driver.findElement(By.id("package-departing-hp-package"));
        WebElement return_date = driver.findElement(By.id("package-returning-hp-package"));
        WebElement search = driver.findElement(By.id("search-button-hp-package"));

        // Send data to elements
        flight_origin.sendKeys("New York");
        departure_date.sendKeys("09/03/2014");
        return_date.clear();
        return_date.sendKeys("09/10/2014");
        flight_destination.sendKeys("New York");
        search.click();
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @AfterEach
    public void tearDown() throws Exception {
        String fileName = getRandomString(10) + ".png";
        String directory = "screenshots//";

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        driver.quit();
    }
}
