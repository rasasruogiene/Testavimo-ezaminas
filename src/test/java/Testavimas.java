import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v101.browser.Browser;
import org.openqa.selenium.support.ui.Select;

public class Testavimas {
    static WebDriver browser;

    @BeforeEach
    public void setup() {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\moksleivis\\IdeaProjects\\Egzaminas\\src\\test\\chromedriver\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://localhost:8080/prisijungti");
        browser.manage().window().maximize();
    }

    @Test
//Naujo vartotojo registracija.Pozytivus testas

    public void newAccount() throws InterruptedException {
        browser.findElement(By.tagName("a")).click();
        browser.findElement(By.id("username")).sendKeys("Rokas");
        browser.findElement(By.id("password")).sendKeys("Namas");
        browser.findElement(By.id("passwordConfirm")).sendKeys("Namas");
        browser.findElement(By.tagName("button")).click();
        Thread.sleep(2000);
        browser.quit();

    }

    //Naujo vartotojo registracija.Negativus testas
    @Test
    public void NegativeInput() {
        browser.findElement(By.tagName("a")).click();
        browser.findElement(By.id("username")).sendKeys("Rita");
        browser.findElement(By.id("password")).sendKeys("");
        browser.findElement(By.id("passwordConfirm")).sendKeys("");
        browser.findElement(By.tagName("button")).click();
        browser.quit();
    }

    //Esamo vartotojo prisijungimas.Pozytivus testas
    @Test
    public void loginToAccount() throws InterruptedException {

        browser.findElement(By.className("form-control")).sendKeys("Rasa");
        browser.findElement(By.name("password")).sendKeys("Egzaminas");
        browser.findElement(By.tagName("button")).click();
        Thread.sleep(2000);
        browser.quit();
    }


    //Esamo vartotojo prisijungimas negatyvus testas
    @Test
    public void negativeLoginToAccount() throws InterruptedException {
        browser.findElement(By.className("form-control")).sendKeys("Rasa");
        browser.findElement(By.name("password")).sendKeys("");
        browser.findElement(By.name("button")).click();
        Thread.sleep(2000);
        browser.quit();

    }
    //Naujo iraso sukurimas,pozytivus testas

    @Test
    public void newInput() {
        browser.findElement(By.id("sk1")).sendKeys("50");
        browser.findElement(By.id("sk2")).sendKeys("50");
        browser.findElement(By.name("zenklas"));
        browser.findElement(By.xpath("//*[@id=\"number\"]/select/option[1]"));
        browser.findElement(By.cssSelector("#number > input[type=submit]:nth-child(10)")).click();
        browser.quit();
    }

    //Naujo iraso sukurimas.Negatyvus testas
    @Test
    public void newIncorrectInput() {
        browser.findElement(By.id("sk1")).sendKeys("-20");
        browser.findElement(By.id("sk2")).sendKeys("30");
        browser.findElement(By.name("zenklas"));
        browser.findElement(By.xpath("//*[@id=\"number\"]/select/option[1]"));
        browser.findElement(By.cssSelector("#number > input[type=submit]:nth-child(10)")).click();
        browser.quit();
    }
}



