import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.MainAuthAreaPage;
import pages.PersonalInfoPage;

public class MainTest {

    private WebDriver driver;
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    private static final String URL = "https://otus.ru";

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
        if (driver != null)
            driver.quit();
    }

    @Test
    public void otusTest() {
        driver.get(URL);
        logger.info("Открыли https://otus.ru");
        LoginPage loginPage = new LoginPage(driver);
        MainAuthAreaPage mainAuthAreaPage = new MainAuthAreaPage(driver);
        PersonalInfoPage personalInfoPage = new PersonalInfoPage(driver);
        loginPage.auth();
        logger.info("Авторизовались на сайте");
        mainAuthAreaPage.goToProfilePage();
        logger.info("Вошли в личный кабинет");
        personalInfoPage.fillPersonalInfo();
        logger.info("В разделе \"О себе\" заполнили все поля \"Личные данные\" и добавить не менее двух контактов и нажали сохранить");
        driver.manage().deleteAllCookies();
        driver.get(URL);
        logger.info("Открыли https://otus.ru в \"чистом браузере\"");
        loginPage.auth();
        logger.info("Авторизовались на сайте");
        mainAuthAreaPage.goToProfilePage();
        logger.info("Вошли в личный кабинет");
        personalInfoPage.checkPersonalInfo();
        logger.info("Проверили, что в разделе \"О себе\" отображаются указанные ранее данные");
    }
}