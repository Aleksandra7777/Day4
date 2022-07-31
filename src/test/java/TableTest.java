import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends TestBase {
    @Test
    public void shouldPrintMountainsOver4000() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : rows) {
            System.out.println("Nazwa gory:");
            WebElement name = row.findElements(By.cssSelector("td")).get(0);
            WebElement nameHeight = row.findElements(By.cssSelector("td")).get(3);
            int height = Integer.parseInt(nameHeight.getText());
            if (height>4000) {
                System.out.println(name.getText());
            }
        }
    }
}
