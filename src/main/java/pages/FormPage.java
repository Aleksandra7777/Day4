package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='inputLastName3']")
    private WebElement lastName;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexOptions;

    @FindBy(id = "selectContinents")
    private WebElement continent;

    @FindBy(id = ("inputEmail3"))
    private WebElement email;

    @FindBy(id = "inputAge3")
    private WebElement age;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experienceOptions;

    @FindBy(id = "gridCheckManulTester")
    private WebElement manualTester;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommands;

    @FindBy(id = "chooseFile")
    private WebElement fileUpload;

    @FindBy(className = "btn-primary")
    private WebElement sendFormButton;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;


    public FormPage setFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    public FormPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public FormPage selectMaleGender() {
        sexOptions.get(0).click();
        return this;
    }

    public FormPage selectContinent(String optionValue) {
        new Select(continent).selectByValue(optionValue);
        return this;
    }

    public FormPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public FormPage setAge(String age) {
        this.age.sendKeys(age);
        return this;
    }

    public FormPage selectExperience(int yearsOfExperience) {
        experienceOptions.get(yearsOfExperience - 1).click();
        return this;
    }

    public FormPage selectManualTester() {
        manualTester.click();
        return this;
    }

    public FormPage selectSeleniumCommands(String optionValue) {
        new Select(seleniumCommands).selectByValue(optionValue);
        return this;
    }

    public FormPage uploadFile(File file) {
       fileUpload.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage sendFormButton () {
        sendFormButton.click();
        return this;
    }

    public String getValidatorMessage (){
        return validatorMessage.getText();
    }



}
