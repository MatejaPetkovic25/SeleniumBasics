package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
//Zadatak 2
//Na sajtu https://cms.demo.katalon.com/ dodati u korpu "Patient ninja" proizvod i proveriti da li je dodat u korpu

       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();

       driver.navigate().to("https://cms.demo.katalon.com/");
       driver.findElement(By.cssSelector(".product.type-product.post-66.status-publish.last.instock.product_cat-clothing.product_cat-hoodies.has-post-thumbnail.taxable.shipping-taxable.purchasable.product-type-simple")).click();
       driver.findElement(By.name("add-to-cart")).click();
       driver.findElement(By.cssSelector(".button.wc-forward")).click();

       String ocekivaniRezultat = "Patient Ninjaz";
       String dobijeniRezultat = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/main/article/div/div/form/table/tbody/tr[1]/td[3]/a")).getText();

        Assert.assertEquals(dobijeniRezultat, ocekivaniRezultat);
        WebElement element = driver.findElement(By.className("product-thumbnail"));
        Assert.assertTrue(element.isDisplayed());

    }
}
