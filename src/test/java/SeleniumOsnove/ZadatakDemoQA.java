package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ZadatakDemoQA {
    public static void main(String[] args) {
        //Zadatak 2 - Ulogovati se na sajt https://demoqa.com/ preko kolacica, izlogovati se i asertovati da je korisnik izlogovan

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/login");

        driver.manage().deleteAllCookies();

        Cookie kolacicUsername = new Cookie("userName", "nekijuzernejm1");
        Cookie kolacicUserID = new Cookie("userID", "097688bc-a92b-48e1-a748-b45821866b6b");
        Cookie kolacicToken = new Cookie("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im5la2lqdXplcm5lam0xIiwicGFzc3dvcmQiOiJBYjEyMy4hKiIsImlhdCI6MTY1NDE5NTk5NH0.ezzCL2gDf38xtMHwXHxfghwVqKBTNSfUmWzRpb4Dzg4" );
        Cookie kolacicExpires = new Cookie("expires", "2022-06-09T18%3A53%3A14.698Z");

        driver.manage().addCookie(kolacicUsername);
        driver.manage().addCookie(kolacicUserID);
        driver.manage().addCookie(kolacicToken);
        driver.manage().addCookie(kolacicExpires);

        driver.navigate().refresh();

       // WebElement profil = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div/label/a"));
       // profil.click();

        WebElement logout = driver.findElement(By.id("submit"));
        logout.click();

        WebElement login = driver.findElement(By.id("login"));
        WebElement usernameTextbox = driver.findElement(By.id("userName"));
        String expectedURL = "https://demoqa.com/login";

        Assert.assertTrue(login.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl() ,expectedURL);
        Assert.assertTrue(usernameTextbox.isDisplayed());


    }
}
