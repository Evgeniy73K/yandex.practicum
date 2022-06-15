import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Settings {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        timeouts.implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}