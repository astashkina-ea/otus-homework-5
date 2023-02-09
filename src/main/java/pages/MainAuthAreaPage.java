package pages;

import helper.ActionsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainAuthAreaPage {

    private WebDriver driver;

    private By userItem = By.xpath("//*[@data-name='user-info']");
    private By userItemProfile = By.xpath("//a[contains(text(),'Мой профиль')]");

    public MainAuthAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToProfilePage() {
        ActionsElements actionsElement = new ActionsElements(driver);
        actionsElement.getElement(userItem);
        actionsElement.moveToElement(userItem);
        actionsElement.click(userItemProfile);
    }
}