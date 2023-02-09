package pages;

import helper.ActionsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInfoPage {

    private WebDriver driver;

    //локаторы ФИ
    private By firstNameField = By.xpath("//input[@name='fname']");
    private By lastNameField = By.xpath("//input[@name='lname']");
    private By firstNameLatinField = By.xpath("//input[@name='fname_latin']");
    private By lastNameLatinField = By.xpath("//input[@name='lname_latin']");
    private By blogNameField = By.xpath("//input[@name='blog_name']");
    //локаторы для календаря
    private By dateOfBirthField = By.xpath("//input[@name='date_of_birth']");
    //локатор для  страны
    private By сountryField = By.xpath("//input[@name='country']/parent::label/parent::div");
    private By countrySelection = By.xpath("//button[@title='Россия']");
    //локаторы для города
    private By cityField = By.xpath("//input[@data-title='Город']/parent::label/parent::div");
    private By citySelection = By.xpath("//button[@title='Пенза']");
    //локаторы для уровня языка
    private By languageField = By.xpath("//input[@data-title='Уровень знания английского языка']/parent::label/parent::div");
    private By languageSelection = By.xpath("//button[@title='Выше среднего (Upper Intermediate)']");
    //локатор для готовности к переезду
    private By relocateRadioButton = By.xpath("//input[@id='id_ready_to_relocate_0']//following-sibling::span");
    private By relocateRadioButtonChecked = By.xpath("//input[@id='id_ready_to_relocate_0']");
    //локатор для формата работы
    private By workFormatCheckBox = By.xpath("//input[@title='Полный день']/parent::label/span");
    private By workFormatCheckBoxChecked = By.xpath("//input[@title='Полный день']");
    //локатор для способов связи
    private By сommunicationFieldOne = By.xpath("//input[@name='contact-0-service']/following-sibling::div");
    private By сommunicationSelectionOne = By.xpath("//button[@data-value='skype']");
    private By сontactOneField = By.xpath("//input[@id='id_contact-0-value']");
    private By сommunicationFieldTwo = By.xpath("//input[@name='contact-1-service']/following-sibling::div");
    private By сommunicationSelectionTwo = By.xpath("//input[@name='contact-1-service']/parent::label/following-sibling::div/descendant::button[@data-value='telegram']");
    private By contactTwoField = By.xpath("//input[@id='id_contact-1-value']");
    //локаторы для пола
    private By gendersField = By.xpath("//select[@id='id_gender']");
    private By genderSelection = By.xpath("//option[@value='f']");
    //локатор для компании
    private By companyField = By.xpath("//input[@id='id_company']");
    //локатор для должности
    private By positionField = By.xpath("//input[@id='id_work']");
    //локаторы для опыта разработки
    private By experienceField = By.xpath("//select[@id ='id_experience-0-experience']");
    private By experienceSelection = By.xpath("//option[text()='Java']");
    private By experienceLevelField = By.xpath("//select[@id ='id_experience-0-level']");
    private By experienceLevelSelection = By.xpath("//option[text()='Более 10 лет']");
    private By saveButton = By.xpath("//button[@name='continue']");

    private String firstNameValue = "Тест";
    private String lastNameValue = "Тестов";
    private String firstNameLatinValue = "Test";
    private String lastNameLatinValue = "Testov";
    private String blogNameValue = "Tecт";
    private String dateOfBirthValue = "15.05.1996";
    private String countryValue = "Россия";
    private String cityValue = "Пенза";
    private String languageValue = "Выше среднего (Upper Intermediate)";
    private String сontactOneValue = "@test_skype";
    private String contactTwoValue = "@test_telegram";
    private String companyValue = "ООО \"Test\"";
    private String positionValue = "Тестировщик";


    public PersonalInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPersonalInfo() {
        ActionsElements actionsElement = new ActionsElements(driver);
        actionsElement.enterToTextArea(firstNameField, firstNameValue);
        actionsElement.enterToTextArea(lastNameField, lastNameValue);
        actionsElement.enterToTextArea(firstNameLatinField, firstNameLatinValue);
        actionsElement.enterToTextArea(lastNameLatinField, lastNameLatinValue);
        actionsElement.enterToTextArea(blogNameField, blogNameValue);
        actionsElement.enterToTextArea(dateOfBirthField, dateOfBirthValue);
        actionsElement.moveToElement(сountryField);
        actionsElement.click(сountryField);
        actionsElement.getElement(countrySelection);
        actionsElement.click(countrySelection);
        actionsElement.moveToElement(cityField);
        actionsElement.click(cityField);
        actionsElement.getElement(citySelection);
        actionsElement.click(citySelection);
        actionsElement.click(languageField);
        actionsElement.click(languageSelection);
        actionsElement.click(relocateRadioButton);
        actionsElement.click(workFormatCheckBox);
        actionsElement.moveToElementAndClick(сommunicationFieldOne);
        actionsElement.getElement(сommunicationSelectionOne);
        actionsElement.click(сommunicationSelectionOne);
        actionsElement.click(сontactOneField);
        actionsElement.enterToTextArea(сontactOneField, сontactOneValue);
        actionsElement.moveToElementAndClick(сommunicationFieldTwo);
        actionsElement.getElement(сommunicationSelectionTwo);
        actionsElement.click(сommunicationSelectionTwo);
        actionsElement.click(contactTwoField);
        actionsElement.enterToTextArea(contactTwoField, contactTwoValue);
        actionsElement.click(gendersField);
        actionsElement.click(genderSelection);
        actionsElement.enterToTextArea(companyField, companyValue);
        actionsElement.enterToTextArea(positionField, positionValue);
        actionsElement.click(experienceField);
        actionsElement.click(experienceSelection);
        actionsElement.click(experienceLevelField);
        actionsElement.click(experienceLevelSelection);
        actionsElement.submit(saveButton);
    }

    public void checkPersonalInfo() {
        ActionsElements actionsElement = new ActionsElements(driver);
        actionsElement.checkAttribute(firstNameField, firstNameValue);
        actionsElement.checkAttribute(lastNameField, lastNameValue);
        actionsElement.checkAttribute(firstNameLatinField, firstNameLatinValue);
        actionsElement.checkAttribute(lastNameLatinField, lastNameLatinValue);
        actionsElement.checkAttribute(blogNameField, blogNameValue);
        actionsElement.checkAttribute(dateOfBirthField, dateOfBirthValue);
        actionsElement.checkText(сountryField, countryValue);
        actionsElement.checkText(cityField, cityValue);
        actionsElement.checkText(languageField, languageValue);
        actionsElement.checkAttributeChecked(relocateRadioButtonChecked);
        actionsElement.checkAttributeChecked(workFormatCheckBoxChecked);
        actionsElement.checkAttribute(сontactOneField, сontactOneValue);
        actionsElement.checkAttribute(contactTwoField, contactTwoValue);
        actionsElement.checkAttributeChecked(genderSelection);
        actionsElement.checkAttribute(companyField, companyValue);
        actionsElement.checkAttribute(positionField, positionValue);
        actionsElement.checkAttributeChecked(experienceSelection);
        actionsElement.checkAttributeChecked(experienceLevelSelection);
    }
}