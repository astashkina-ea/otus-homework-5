package pages;

import helper.ActionsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainUnAuthAreaPage {

    private WebDriver driver;

    private By signInButton = By.cssSelector(".header3__button-sign-in");

    public MainUnAuthAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonSignInButton() {
        ActionsElements actionsElement = new ActionsElements(driver);
        actionsElement.click(signInButton);
    }
}