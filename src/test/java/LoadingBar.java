import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoadingBar extends TestBase {
    @Test
    public void shouldWaitForProressBarText() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebElement progressBarLabel = driver.findElement(By.className("progress-label"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(progressBarLabel, "Complete!"));
    }
}
