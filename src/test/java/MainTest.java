import component.DropDownMenuComponent;
import component.HeaderComponentAuthArea;
import component.HeaderComponentUnauthArea;
import component.PersonalInfoForm;
import component.modal.LoginModal;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainBasePage;

public class MainTest {

    private WebDriver driver;
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    @BeforeAll
    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void otusTest() {

        MainBasePage mainPage = new MainBasePage(driver);
        HeaderComponentUnauthArea headerComponent = new HeaderComponentUnauthArea(driver);
        LoginModal loginModal = new LoginModal(driver);
        HeaderComponentAuthArea headerComponentAuthArea = new HeaderComponentAuthArea(driver);
        DropDownMenuComponent dropDownMenuComponent = new DropDownMenuComponent(driver);
        PersonalInfoForm personalInfoForm = new PersonalInfoForm(driver);

        mainPage.open();
        logger.info("Открыли https://otus.ru");
        loginModal.modalShouldNotBeVisible();

        headerComponent.clickSignInButton();
        loginModal.modalShouldBeVisible();
        loginModal.fillAuthForm();
        logger.info("Авторизовались на сайте");

        headerComponentAuthArea.moveToUserItem();
        dropDownMenuComponent.clickUserItem();
        logger.info("Вошли в личный кабинет");

        personalInfoForm.fillPersonalInfo();
        logger.info("В разделе \"О себе\" заполнили все поля \"Личные данные\" и добавили не менее двух контактов и нажали сохранить");

        driver.manage().deleteAllCookies();
        mainPage.open();
        logger.info("Открыли https://otus.ru в \"чистом браузере\"");

        headerComponent.clickSignInButton();
        loginModal.fillAuthForm();
        logger.info("Авторизовались на сайте");

        headerComponentAuthArea.moveToUserItem();
        dropDownMenuComponent.clickUserItem();
        logger.info("Вошли в личный кабинет");

        personalInfoForm.checkPersonalInfo();
        logger.info("Проверили, что в разделе \"О себе\" отображаются указанные ранее данные");
    }
}