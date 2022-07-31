import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class SeleniumAutomationScript {
//poczatek metody Selenium, testowej z importem web drivera chrome
    WebDriver driver;
    @BeforeMethod
    void setUp(){
    //wybiera przegladarke
    WebDriverManager.chromedriver().setup();
    //obiekt, na ktorym wywoalamy metode
    ChromeOptions options = new ChromeOptions();
    //ustawienia obiekt czyli
    // w sumie chrome na pełny ekran, można wpisać też rozdizelcozść
    options.addArguments("start-maximized");
    // NAJWAŻNIEJSZA LINIA ctr + LPM opis funkcji
    // inicilizacja drivera z "options "na pełny ekran" - patrz wyżej
    // jezęli coś na czerwono sie swiecie to alt+enter to jest ipmort
    // takie ustawienia tylko dla chrome, jezlei inna przegladarka to wracam do WebDriverManager
    driver = new ChromeDriver(options);
    //otwieranie storny jako string
    driver.get("https://seleniumui.moderntester.pl/form.php");
}
    @AfterMethod
    void tearDown(){
        driver.quit(); //driver.close() - zamykanie jednej karty
    }
    @Test
    public void login() throws InterruptedException {

//        //przygotowanie - to bylo jesli bez before i aftera
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        //inicjalizacja drivera
//        WebDriver driver = new ChromeDriver(options);
//        //otwieranie konkretnej strony
//        driver.get("https://seleniumui.moderntester.pl/form.php");
//        //zmakniecie drivera

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Ola");
        WebElement lastName = driver.findElement(By.xpath("//*[@id='inputLastName3']"));
        lastName.sendKeys("Fujak");
        //WebElement mail = driver.findElement(By.cssSelector("#inputEmail3"));
//        firstName.clear();
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("test@test.com");
//        WebElement sex = driver.findElement(By.xpath("//*[@id='gridRadiosFemale']"));
//        sex.click();
        //zaintalowac selectorHub rozszerzenie w chromie
        List<WebElement> sexOptions = driver.findElements(By.xpath("//input[@name='gridRadiosSex']"));
        for (WebElement sexoption : sexOptions) {
            sexoption.click();
//            Thread.sleep(500);
        }

        //pole Age
        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.sendKeys("32");
        //pole year of experience
        WebElement yearOfExperience = driver.findElement(By.xpath("//input[@id='gridRadios1']"));
        yearOfExperience.click();
        //profession
        WebElement proffesion = driver.findElement(By.xpath("//input[@id='gridCheckAutomationTester']"));
        proffesion.click();
        //continents
        WebElement webElementcontinents = driver.findElement(By.xpath("//select[@id='selectContinents']"));
        Select continents = new Select(webElementcontinents);
        continents.selectByValue("europe");
//        Thread.sleep(1000);
        continents.selectByIndex(4);
        //comands
        WebElement comands = driver.findElement(By.xpath("//select[@id='selectSeleniumCommands']"));
        Select comandsSelect = new Select(comands);
//        for(int i=0; i<=4; i++){
//            comandsSelect.selectByIndex(i);
//            Thread.sleep(1000);
//        }
        comandsSelect.selectByIndex(0);
//        Thread.sleep(1000);
        comandsSelect.selectByIndex(1);
//        Thread.sleep(1000);

        //file
        WebElement browse = driver.findElement(By.xpath("//input[@id='chooseFile']"));
        browse.sendKeys("C:\\TestData\\plik.txt");
//        Thread.sleep(1000);

        WebElement field = driver.findElement(By.xpath("//textarea[@id='additionalInformations']"));
        field.sendKeys("test");
//        Thread.sleep(1000);

        WebElement testFile = driver.findElement(By.xpath("//a[normalize-space()='Test File to Download']"));
        testFile.click();
//        Thread.sleep(1000);

        WebElement sendSign = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        sendSign.click();
//Co można zrobić, aby poczekać na komunikat potwierdzenia i dopiero dalej?
//        Thread.sleep(1000);
        Thread.sleep(5000);

        String expectedMessage = "Form send with success";
        WebElement confirmatonMessage = driver.findElement(By.xpath("//div[@id='validator-message']"));
        String acctual = confirmatonMessage.getText();
        System.out.println("formularz zostal wyslany z wiadomoscia" + acctual);
        assertEquals(expectedMessage, acctual);
//        driver.quit();
    }
    //koniec metody
}
