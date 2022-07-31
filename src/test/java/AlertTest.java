import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest extends TestBase{

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        // kliknąć w przycisk Prompt Pop up
        WebElement promtButton = driver.findElement(By.id("prompt-alert"));
        promtButton.click();
        // w alercie wpisz Ola
        driver.switchTo().alert().sendKeys("Ola");
        // w alercie kliknij ok
        driver.switchTo().alert().accept();
        // sprawdź asercja czy tekst pod przyciskiem jest rowny
        // hello Ola....
//        driver.findElement(By.id("promt-label"));
        WebElement promptLabel = driver.findElement(By.id("prompt-label"));
        String actual = promptLabel.getText();
        Assert.assertEquals(actual, "Hello Ola! How are you today?");
    }

//        @Test
//        public void syncTest() {
//            driver.get("https://seleniumui.moderntester.pl/alerts.php");
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement click = driver.findElement(By.id("delayed-alert"));
//            click.click();
//            wait.until(ExpectedConditions).alertIsPresent();
//            driver.switchTo().alert().accept();
//        }
        @Test
        public void shouldWaitForAlert() {
            driver.get("https://seleniumui.moderntester.pl/alerts.php");

            WebElement delayedBtn = driver.findElement(By.id("delayed-alert"));
            delayedBtn.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            driver.switchTo().alert().accept();
    }
}
