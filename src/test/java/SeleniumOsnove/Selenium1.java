package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");

        //driver.navigate().to("www.google.com");
        //Pogresan nacin unosa URL-a je bez 'https://'

        driver.navigate().to("https://www.youtube.com");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.manage().window().maximize();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();
        driver.quit();


    }
}
