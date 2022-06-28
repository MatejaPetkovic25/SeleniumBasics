package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium6ImplicitniWait {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String URL = "https://gigatron.rs/";
        driver.navigate().to(URL);

        Thread.sleep(5000);
        //Eksplicitni wait
        //Program ce cekati koliko mu mi zadamo sekundi (sta god da se desi cekace toliko)
        //Koristi se dok se PRAVI test
        //Kada vidimo da smo zavrsili test onda prebacujemo thread sleep u web driver wait

        WebElement button = driver.findElement(By.cssSelector(".btn.primary"));

        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wdwait.until(ExpectedConditions.elementToBeClickable(button));
        //Implicitni wait
        //Program ce cekati dok se ne ispuni zadat uslov (u ovom slucaju da dugme postane klikabilno)
        //i cekace najvise 10 sekundi, jer smo toliko zadali u objektu da ce najduze da se ceka
        //Ako program ne pronadje taj element, cekace 10 sekundi (koliko je maksimalno) i na kraju ce puci
        //Najcesci implicitni waiteri su elementToBeClickable i visibilityOf
        //prvi je da se ceka da element postane klikabilan
        //drugi je da se ceka da se element prikaze

        //Implicitni wait moze da skrati dosta vremena u testiranju
        //Primera radi: ako imamo 10 testova, u svakom testu imamo po 5 thread sleep-ova sa 2 sekunde
        //to znaci da cemo za tih 10 testova ukupno cekati 100 sekundi
        //ako koristimo implicit wait, to vreme cekanja moze da se smanji na ukupno 20 sekundi cekanja
        //Zakljucak: sto vise testova imamo to cemo vise vremena da ustedimo ako koristimo implicit wait

        button.click();


    }

}