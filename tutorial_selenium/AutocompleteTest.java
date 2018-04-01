package tutorial_selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutocompleteTest {
    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void SetUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        //Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAutocomplete() throws Exception {
        driver.get(baseUrl);
        String searchingText = "New York, NY, United States (JFK-John F. Kennedy Intl.)";
        String partialText = "New York";

        WebElement text = driver.findElement(By.id("package-origin-hp-package"));
        text.sendKeys(partialText);

        WebElement element = driver.findElement(By.className("display-group-results"));
        List<WebElement> results = element.findElements(By.tagName("a"));
        int size = results.size();

        System.out.println(size);
        Thread.sleep(300);

        for (WebElement result: results) {
            if (result.getText().contains("FK-John")){
                System.out.println("Prawdziwe SPELnione");
                Thread.sleep(1000);
                result.click();
            }
        }



        Thread.sleep(3000);

    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }






}