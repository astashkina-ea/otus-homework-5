package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownMenuComponent extends AbsBaseComponent{

    public DropDownMenuComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href*=personal]")
    private WebElement userItemProfile;

    public void clickUserItem() {
        userItemProfile.click();
    }
}
