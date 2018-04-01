package basicweb2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;



class HiddenElementsTest {

        WebDriver driver;
        String baseUrl1;
        String baseUrl2;

        @BeforeEach
        void setUp() {
            driver = new FirefoxDriver();
            baseUrl1 = "https://letskodeit.teachable.com/p/practice";
            baseUrl2 = "http://www.expedia.com";
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        @Test
        public void testLetsKodeIt() throws Exception {
                driver.get(baseUrl1);

                WebElement textBox = driver.findElement(By.id("displayed-text"));
                System.out.println("Text Box Displayed" + textBox.isDisplayed());

                Thread.sleep(3000);
                WebElement hideButton = driver.findElement(By.id("hide-textbox"));
                hideButton.click();
                System.out.println("Clicked on hide button");
                System.out.println("Text Box Displayed: " + textBox.isDisplayed());

                Thread.sleep(3000);

                //show-text
                WebElement showButton = driver.findElement(By.id("hide-textbox"));
                showButton.click();
                System.out.println("Clicked on show button");
                System.out.println("Text Box Displayed: " + textBox.isDisplayed());


        }

        @Test
        public void  testExpedia() throws InterruptedException {
            driver.get(baseUrl2);
            WebElement childDropdown = driver.findElement(By.id("package-1-age-select-1"));
            System.out.println("Child Dropdown Displayed: " + childDropdown.isDisplayed());

        }



        @AfterEach
        void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }


}