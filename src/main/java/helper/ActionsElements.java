package helper;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsElements {

    private WebDriver driver;
    private Actions action;

    public ActionsElements(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void moveToElement(By locator) {
        action = new Actions(driver);
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).pause(2000).perform();
        driver.findElement(locator);
    }

    public void moveToElementAndClick(By locator) {
        action = new Actions(driver);
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).click().perform();
        driver.findElement(locator);
    }

    public WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void enterToTextArea(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

//    public void enterToTextArea(WebElement webElement, String str) {
//        webElement.clear();
//        webElement.sendKeys(str);
//    }

    public void submit(By locator) {
        driver.findElement(locator).submit();
    }

    public void checkAttribute(By locator, String expect) {
        Assertions.assertEquals(expect, driver.findElement(locator).getAttribute("value"));
    }

    public void checkText(By locator, String expect) {
        Assertions.assertEquals(expect, driver.findElement(locator).getText());
    }

    public void checkAttributeChecked(By locator) {
        Assertions.assertTrue(driver.findElement(locator).isSelected());
    }
}