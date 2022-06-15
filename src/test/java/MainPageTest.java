import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderPage;

import java.util.List;
import java.util.Set;

public class MainPageTest extends Settings {
    @Test
    public void dropdownFaqTest() {
        mainPage = new MainPage(driver);
        mainPage.acceptCooke();
        Assert.assertTrue(mainPage.clickOnQuestion());

    }

    @Test
    public void checkScooterLogoClickTest(){
        OrderPage orderPage;
        mainPage = new MainPage(driver);
        mainPage.acceptCooke();
        orderPage = mainPage.clickOrderPage();
        Assert.assertTrue(orderPage.redirectMainPage().equals("https://qa-scooter.praktikum-services.ru/"));
    }

    @Test
    public void checkYandexLogoClickTest(){
        mainPage = new MainPage(driver);
        String window1 = driver.getWindowHandle();
        mainPage.clickYandexLogo();
        Set<String> windows = driver.getWindowHandles();
        String window2 = null;
        for (String window : windows){
            if(!window.equals(window1)){
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://yandex.ru/"));
        Assert.assertTrue(windows.size()>1);


    }

    @Test
    public void fakeOrderTest(){
        mainPage = new MainPage(driver);
        mainPage.acceptCooke()
                .checkOrder("9943543599");
       try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(mainPage.checkNotFound().size() > 0);

    }

}
