//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class LoadingBarTests extends TestBase {
//
//    @Test
//    public void shouldWaitForLoadingBar() {
//        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
//
//        //implicit wait nie powinien byc nigdy w tescie, ale w klasie bazowej
//        //tutaj jest tylko dla przykladu jego dzialania
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        WebElement progressBar = driver.findElement(By.xpath("//div[.='Complete!')"));
////        WebElement progressBarLabel = driver.findElement(By.className("progress-label"));
//
//        Assert.assertEquals(progressBar.getText(), "Complete!");
//    }
//
//    @Test
//    public void shouldWaitForLoadingBarWithExplicitWait() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated());
//    }
//}
