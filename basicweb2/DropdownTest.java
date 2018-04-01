package basicweb2;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

class DropdownTest {
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
    public void testDropdown() throws Exception {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.id("carselect"));
        Select sel = new Select(element);

        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        sel.selectByValue("benz");


        Thread.sleep(2000);
        System.out.println("Select Honda by index");
        sel.selectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select BMW by visible text");
        sel.selectByVisibleText("BMW");


        Thread.sleep(2000);
        System.out.println("Print the list of all options");
        List<WebElement> options = sel.getOptions();
        int size = options.size();

        for (int i=0; i<size; i++){
            String optionName = options.get(i).getText();
            System.out.println(optionName);
        }
    }


    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}