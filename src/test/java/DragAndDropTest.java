import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class DragAndDropTest extends TestBase {
    @Test
    public void verifyDragAndDrop () {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();
        Assert.assertEquals(drop.getText(), "Dropped!");
    }
}