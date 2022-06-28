package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//Zadatak 1
       // Pokrenuti browser, otici na google, otvoriti jos 2 taba, u drugom otici na youtube, u trecem otici na linkedin.
        // Nakon toga zatvoriti sve tabove posebno.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String google = "https://www.google.com";
        String youtube = "https://www.youtube.com";
        driver.navigate().to(google);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());

        Thread.sleep(1000);
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to(youtube);
        Thread.sleep(1000);
        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com");
        Thread.sleep(1000);
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(listaTabova.get(1));
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(listaTabova.get(0));
        driver.close();


    }
}
