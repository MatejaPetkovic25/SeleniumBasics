package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 3
        //Otvoriti browser, otici na google, pretraziti "itbootcamp", otvoriti prvi link i asertovati URL

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("itbootcamp");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3")).click();

        String ocekivaniURL = "https://itbootcamp.rs/?script=cir";
        String dobijeniURL = driver.getCurrentUrl();

        Assert.assertEquals(dobijeniURL, ocekivaniURL);
    }
}
