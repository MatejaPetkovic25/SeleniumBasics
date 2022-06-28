package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak7PravljenjeTestova {
    // Testiranje logina na sajtu: https://practicetestautomation.com/

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement usernameBox;
    WebElement passwordBox;
    WebElement submitButton;

    String validUsername = "student";
    String validPassword = "Password123";

    String invalidUsername = "invalid username";

    String invalidPassword = "invalidpass";

    String invalidUsernameMessage = "Your username is invalid!";

    String InvalidPasswordMessage = "Your password is invalid!";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
        WebElement practicePage = driver.findElement(By.id("menu-item-20"));
        practicePage.click();
        WebElement loginPage = driver.findElement(By.linkText("Test Login Page"));
        loginPage.click();

        usernameBox = driver.findElement(By.id("username"));
        passwordBox = driver.findElement(By.id("password"));
        submitButton = driver.findElement(By.id("submit"));
    }

    @Test (priority = 10)
    public void testWithValidInput() {
       // WebElement usernameBox = driver.findElement(By.id("username"));
       // WebElement passwordBox = driver.findElement(By.id("password"));
       // WebElement submitButton = driver.findElement(By.id("submit"));

        usernameBox.sendKeys(validUsername);
        passwordBox.sendKeys(validPassword);
        submitButton.click();

        WebElement logoutButton = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));

        Assert.assertEquals(driver.findElement(By.className("post-title")).getText(), "Logged In Successfully");
        Assert.assertTrue(logoutButton.isDisplayed());
        boolean check = false;
        try {
            check = submitButton.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);
    }

    @Test (priority = 20)
    public void testWithoutInput() throws InterruptedException {
        submitButton.click();
        //Thread.sleep(2000);
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), invalidUsernameMessage);
        Assert.assertTrue(submitButton.isDisplayed());
    }

    @Test (priority = 30)
    public void testWithInvalidUsername() throws InterruptedException {
        usernameBox.sendKeys(invalidUsername);
        passwordBox.sendKeys(validPassword);
        submitButton.click();
        //Thread.sleep(2000);
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), invalidUsernameMessage);
        Assert.assertTrue(submitButton.isDisplayed());
    }

    @Test (priority = 40)
    public void testWithInvalidPassword() {
        usernameBox.sendKeys(validUsername);
        passwordBox.sendKeys(invalidPassword);
        submitButton.click();
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed());
        Assert.assertEquals(errorMessage.getText(), InvalidPasswordMessage);
        Assert.assertTrue(submitButton.isDisplayed());
    }

    @Test (priority = 50)
    public void testWithInvalidUsernameAndPassword() {
        usernameBox.sendKeys(invalidUsername);
        passwordBox.sendKeys(invalidPassword);
        submitButton.click();
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), invalidUsernameMessage);
        Assert.assertTrue(submitButton.isDisplayed());
    }

    @Test (priority = 60)
    public void testWithValidUsernameAllCaps() throws InterruptedException {
        usernameBox.sendKeys("STUDENT");
        passwordBox.sendKeys(validPassword);
        submitButton.click();
        //Thread.sleep(2000);
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), invalidUsernameMessage);
        Assert.assertTrue(submitButton.isDisplayed());
    }

    @Test (priority = 70)
    public void testWithPressingEnterInsteadOfClickingSubmit() {
        usernameBox.sendKeys(validUsername);
        passwordBox.sendKeys(validPassword);
        passwordBox.sendKeys(ENTER);

        Assert.assertTrue(submitButton.isDisplayed());
        boolean check = false;
        try {
            check = driver.findElement(By.id("error")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);
    }

    @AfterMethod
    public void removeCookies() throws InterruptedException {
        Thread.sleep(5000);
        driver.manage().deleteAllCookies();
    }

}
