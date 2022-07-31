import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class ForPopTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        File file = new File("src/main/resources/file.txt");
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Mateusz");
        formPage.setLastName("Nowak");
        formPage.selectMaleGender();
        formPage.selectContinent("europe");
        formPage.setEmail("test@test");
        formPage.setAge("39");
        formPage.selectExperience(7);
        formPage.selectManualTester();
        formPage.selectSeleniumCommands("browser-commands");
        formPage.uploadFile(file);
        formPage.sendFormButton();

        Assert.assertEquals(formPage.getValidatorMessage(),"Form send with success");

    }
}

