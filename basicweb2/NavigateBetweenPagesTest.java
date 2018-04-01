package basicweb2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

class NavigateBetweenPagesTest {

    WebDriver driver;
    String baseURL;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println("Title of the page is "  + title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URl is " + currentUrl);


        String urlToNavigate ="https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
        driver.navigate().to(urlToNavigate);
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URl is " + currentUrl);

        Thread.sleep(200);
        driver.navigate().back();
        System.out.println("Navigate back");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URl is " + currentUrl);

        Thread.sleep(200);
        driver.navigate().forward();
        System.out.println("Navigate forward");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URl is " + currentUrl);

        Thread.sleep(200);
        driver.navigate().back();
        System.out.println("Navigate back");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URl is " + currentUrl);

        driver.navigate().refresh();
        System.out.println("NAvigate Refresh");
        driver.get(currentUrl);
        System.out.println("NAvigate Refresh");

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

    }





    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
}