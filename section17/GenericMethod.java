package section17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {
    WebDriver driver;

    public GenericMethod(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(String locator, String type){
        type = type.toLowerCase();
        if(type.equals("id")){
            System.out.println("Element found with id: " + locator);
            return this.driver.findElement(By.id(locator));
        } else if(type.equals("xpath")){
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.xpath(locator));
        } else {
            System.out.println("Locator tye not supported");
            return null;
        }
    }

    public List<WebElement> getElementList(String locator, String type){
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<WebElement>();
        if(type.equals("id")){
            elementList= driver.findElements(By.id(locator));
        } else if(type.equals("xpath")){
            elementList = driver.findElements(By.xpath(locator));
        } else {
            System.out.println("Locator tye not supported");
        }

        if(elementList.isEmpty()){
            System.out.println("Element not found with " + type + " : " + locator);
        } else {
            System.out.println("Element found with " + type + ": " + locator );
        }
        return elementList;
    }


    public boolean isElementPresent(String locator, String type){
        List<WebElement> elementList = getElementList(locator, type);

        int size = elementList.size();

        return  size>0;
    }



    public WebElement waitForElement(By locator, int timeout){
        WebElement element = null;
        try{
            System.out.println("Waiting for max: "+ timeout + " seconds for element to be available");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element appeared on the web page");

        } catch (Exception e){
            System.out.println("Element not appeared on the web page");
        }
        return element;
    }

    public void clickWhenReady(By locator, int timeout){

        try{
            WebElement element = null;
            System.out.println("Waiting for max: "+ timeout + " seconds for element to be available");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("Element clicked on the web page");

        } catch (Exception e){
            System.out.println("Element not appeared on the web page");
        }
    }




}
