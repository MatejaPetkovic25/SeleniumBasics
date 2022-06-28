package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 2
        //Otvoriti browser, otici na google, naci wikipediu i naci clanak o Nikoli Tesli

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Wikipedia");
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]")).click();
        Thread.sleep(1500);
      //  driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3")).click();
        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input")).sendKeys("Nikola Tesla");
        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input")).sendKeys(ENTER);
     driver.findElement(By.xpath("/html/body/div[4]/div[2]/nav[6]/div/ul/li[128]/a/span")).click();

        /*driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Nikola Tesla");
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div[1]/div[2]/div[2]/div/div/div[1]/div/div[1]/div/div/div/div[1]/a/h3")).click();*/

        String ocekivaniNaslov = "Nikola Tesla";
        String dobijeniNaslov = driver.findElement(By.xpath("/html/body/div[3]/h1")).getText();

        String ocekivaniURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        String dobijeniURL = driver.getCurrentUrl();

        Assert.assertEquals(dobijeniNaslov, ocekivaniNaslov);
        Assert.assertEquals(dobijeniURL, ocekivaniURL);

        WebElement slika = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[3]/td/a/img"));

        Assert.assertTrue(slika.isDisplayed());
    }
}
