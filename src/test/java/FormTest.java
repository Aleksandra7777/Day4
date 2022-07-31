import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWIthSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        driver.findElement(By.id("inputLastName3"))
                .sendKeys("Kowalski");

        List<WebElement> genders = driver.findElements(By.name("gridRadiosSex"));
        genders.get(0).click();

        driver.findElement(By.cssSelector("#inputAge3"))
                .sendKeys("15");

        driver.findElement(By.xpath("//input[@id='inputEmail3']"))
                .sendKeys("jk@wp.pl");

        List<WebElement> yearsOfExperience = driver.findElements(By.name("gridRadiosExperience"));
        getRandomElement(yearsOfExperience).click();

        driver.findElement(By.id("gridCheckManulTester")).click();

        Select select = new Select(driver.findElement(By.id("selectContinents")));
        select.selectByValue("europe");

        new Select(driver.findElement(By.id("selectSeleniumCommands")))
                .selectByIndex(2);

        File file = new File("src/main/resources/file.txt");
        driver.findElement(By.id("chooseFile")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.cssSelector(".btn-primary")).click();

        String displayedMsg = driver.findElement(By.id("validator-message"))
                .getText();

        Assert.assertEquals(displayedMsg, "Form send with success");
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int quantityOfElements = elements.size();
        int randomIndexFromList = rnd.nextInt(quantityOfElements);
        return elements.get(randomIndexFromList);
    }
}
