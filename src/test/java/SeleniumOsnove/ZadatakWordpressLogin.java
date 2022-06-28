package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class ZadatakWordpressLogin {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 1 - Napraviti automatski test koji ce se ulogovati na wordpress i proveriti da li je korisnik ulogovan
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String username = "nekijuzernejm1";
        String password = "nekasifra1";

        String vordpres = "https://wordpress.com";

        driver.navigate().to(vordpres);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/nav/ul[2]/li[1]/a")).click();
        Thread.sleep(3000);
        //wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("usernameOrEmail"))));
        driver.findElement(By.id("usernameOrEmail")).sendKeys(username);
        driver.findElement(By.id("usernameOrEmail")).sendKeys(ENTER);
        Thread.sleep(3000);
        //wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("password"))));
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password")).sendKeys(ENTER);
        Thread.sleep(3000);

        //wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"))));

        WebElement element = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        Assert.assertTrue(element.isDisplayed());

        element.click();
        Thread.sleep(3000);
        //wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("gravatar"))));
        WebElement profilSlika = driver.findElement(By.className("gravatar"));
        WebElement logoutDugme = driver.findElement(By.cssSelector(".button.sidebar__me-signout-button.is-compact"));
        String actualResult = driver.findElement(By.className("profile-gravatar__user-display-name")).getText();
        String expectedResult = "nekijuzernejm1";

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertTrue(logoutDugme.isDisplayed());
        Assert.assertTrue(profilSlika.isDisplayed());



    }
}
