package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PravljenjeMima {
    public static void main(String[] args) throws InterruptedException {

//Zadatak je da napravite mim vezan za kurs, QA ili IT generalno. Nadjite koju sliku zelite da uploadujete, dodajte tekst
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://imgflip.com/memegenerator");

        WebElement upload = driver.findElement(By.id("mm-show-upload"));
        upload.click();
        Thread.sleep(2000);
         WebElement uploadImage = driver.findElement(By.id("mm-upload-file"));
         WebElement uploadClick = driver.findElement(By.id("mm-upload-btn"));

        uploadImage.sendKeys("C:\\Users\\Korisnik\\Desktop\\mim.png");
        //uploadImage.click();
        Thread.sleep(3000);

        uploadClick.click();

        WebElement topText = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div[1]/div[1]/textarea"));
        WebElement bottomText = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div[2]/div[1]/textarea"));

        topText.sendKeys("Ja nakon zavrsenog ITBootcamp-a");

        bottomText.sendKeys("moja trzisna vrednost");




    }
}
