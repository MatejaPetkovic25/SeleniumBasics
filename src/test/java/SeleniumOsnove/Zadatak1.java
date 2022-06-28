package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) {
        //Zadatak 1
        //Otvoriti browser, otici na youtube, otici na google, povecati prozor, vratiti se nazad i odraditi refresh

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.youtube.com");
      //  driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().back();
        driver.navigate().refresh();




    }
}
