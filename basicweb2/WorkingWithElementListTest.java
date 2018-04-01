package basicweb2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

class WorkingWithElementListTest {
    WebDriver driver;
    String baseUrl;



    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        List<WebElement> radioButtons = driver.findElements(
                By.xpath("//input[contains(@type, 'radio') and contains(@name, 'cars')]"));
        int size = radioButtons.size();
        System.out.println("Size of the list: " + size);
        boolean isChecked = false;
        for (int i=0; i<size; i++){
            isChecked = radioButtons.get(i).isSelected();

            if(!isChecked) {
                radioButtons.get(i).click();
                Thread.sleep(2000);

            }


        }
    }


    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}