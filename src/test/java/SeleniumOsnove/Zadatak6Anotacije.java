package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak6Anotacije {
    //Zadatak sa pretragom Nikole Tesle na wikipediji koji smo radili na pocetku
    // Seleniuma je potrebno sada uraditi sa anotacijama i ispravnim lokatorima

    WebDriver driver;
    WebDriverWait wdwait;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

    }

    @Test
    public void test() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Wikipedia");
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("btnK"))));
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"))));
        WebElement wikipediaPage = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikipediaPage.click();
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("searchInput"))));
        WebElement wikipediaSearchBox = driver.findElement(By.id("searchInput"));
        wikipediaSearchBox.sendKeys("Nikola Tesla");
        wikipediaSearchBox.sendKeys(ENTER);
        String actualTitle = driver.findElement(By.id("firstHeading")).getText();
        String expectedTitle = "Nikola Tesla";
        WebElement image = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[3]/td/a/img"));
        Assert.assertEquals(actualTitle,expectedTitle);
        Assert.assertTrue(image.isDisplayed());

    }

    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
