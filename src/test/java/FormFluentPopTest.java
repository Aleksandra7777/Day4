import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class FormFluentPopTest extends TestBase{

        @Test
        public void shouldFillFormWithSuccess() {
            driver.get("https://seleniumui.moderntester.pl/form.php");

            File file = new File("src/main/resources/file.txt");
            FormPage formPage = new FormPage(driver);

            formPage.setFirstName("Mateusz")
                .setLastName("Nowak")
                .selectMaleGender()
                .selectContinent("europe")
                .setEmail("test@test")
                .setAge("39")
                .selectExperience(7)
                .selectManualTester()
                .selectSeleniumCommands("browser-commands")
                .uploadFile(file)
                .sendFormButton();

            Assert.assertEquals(formPage.getValidatorMessage(),"Form send with success");

        }
    }

