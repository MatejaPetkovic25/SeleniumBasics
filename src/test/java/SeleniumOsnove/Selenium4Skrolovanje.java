package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4Skrolovanje {
    public static void main(String[] args) {

        //Skrolovanje

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String URL = "https://www.ctshop.rs/";
        driver.navigate().to(URL);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("/html/body/footer/div/section/div/div/div[2]/div[1]"));

        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

}