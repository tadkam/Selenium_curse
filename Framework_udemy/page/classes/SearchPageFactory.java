package Framework_udemy.page.classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
    WebDriver driver;
    private JavascriptExecutor js;

    @FindBy(id="header-history")
    WebElement headerHistory;

    @FindBy(xpath = "//button[@id='tab-flight-tab-hp']")
    WebElement flightsTab;

    @FindBy(id="flight-type-roundtrip-label-hp-flight")
    WebElement roundTrip;

    @FindBy(id="flight-type-multi-dest-label-hp-flight")
    WebElement multipleDestination;

    @FindBy(xpath="//input[@id='package-origin-hp-package']")
    WebElement originCity;

    @FindBy(id="package-destination-hp-package")
    WebElement destinationCity;
    @FindBy(id="package-departing-hp-package")
    WebElement departureDate;

    @FindBy(id="package-returning-hp-package")
    WebElement returnDate;

    public SearchPageFactory(WebDriver driver, JavascriptExecutor javascript) {
        this.driver = driver;
        this.js = javascript;
        PageFactory.initElements(driver, this);
    }

    public void clickFlightsTab() {
        flightsTab.click();
    }

    public void setOriginCity(String origin) {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement element = wait.until(ExpectedConditions.visibilityOf(originCity));
        //originCity.sendKeys(origin);
        js.executeScript("document.getElementById('package-origin-hp-package').value = 'New York'");

    }

    public void setDestinationCity(String destination) {
        destinationCity.sendKeys(destination);
    }

    public void setDepartureDate(String date) {
        departureDate.sendKeys(date);
    }

    public void setReturnDate(String date) {
        returnDate.sendKeys(date);
    }


    public void clickFlightTab() {
        flightsTab.click();
    }

    public void clickroundTrip() {
        roundTrip.click();
    }

    public void clickMultipleDestination() {
        multipleDestination.click();
    }



}
