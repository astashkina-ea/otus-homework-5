package pages;

import helper.ActionsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailField = By.xpath("//form[@action='/login/']//input[@name='email']");
    private By passwordField = By.xpath("//form[@action='/login/']//input[@name='password']");
    private By signInButton = By.xpath("//form[@action='/login/']//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillAuthForm() {
        ActionsElements actionsElement = new ActionsElements(driver);
        actionsElement.getElement(emailField);
        actionsElement.enterToTextArea(emailField, System.getProperty("login"));
        actionsElement.enterToTextArea(passwordField, System.getProperty("password"));
        actionsElement.submit(signInButton);
    }

    public void auth() {
        MainUnAuthAreaPage mainPage = new MainUnAuthAreaPage(driver);
        mainPage.clickButtonSignInButton();
        fillAuthForm();
    }
}