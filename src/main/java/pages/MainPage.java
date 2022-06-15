package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By faqQuestion = By.xpath("//div[@class=\"accordion__heading\"]");
    private By faqAnswer = By.xpath("//div[@aria-disabled=\"true\"]/following::div");
    private By cookieButton = By.xpath("//button[@id=\"rcc-confirm-button\"]");
    private By orderButton = By.xpath("//button[@class=\"Button_Button__ra12g\"]");
    private By yandexLogo = By.xpath("//a[@class=\"Header_LogoYandex__3TSOI\"]");
    private By orderStatusButton = By.xpath("//button[@class=\"Header_Link__1TAG7\"]");
    private By inputOrder = By.xpath("//input[@class=\"Input_Input__1iN_Z Header_Input__xIoUq\"]");
    private By goButton = By.xpath("//button[@class=\"Button_Button__ra12g Header_Button__28dPO\"]");
    private By divNotFound = By.xpath("//img[@alt=\"Not found\"]");


    public MainPage acceptCooke() {
        driver.findElement(cookieButton).click();
        return this;
    }

    public boolean clickOnQuestion() {
        Boolean actual = null;
        List< WebElement> questions = driver.findElements(faqQuestion);
        for (int i = 0; i <questions.size(); i++) {
            questions.get(i).click();
            actual = isDisplayed();
        }

        return actual;



    }


    public Boolean isDisplayed() {
        return driver.findElement(faqAnswer).isDisplayed();
    }

    public OrderPage clickOrderPage(){
        driver.findElement(orderButton).click();
        return new OrderPage(driver);
    }

    public MainPage clickYandexLogo() {
        driver.findElement(yandexLogo).click();
        return this;
    }

    public MainPage checkOrder(String value) {
        driver.findElement(orderStatusButton).click();
        driver.findElement(inputOrder).sendKeys(value);
        driver.findElement(goButton).click();
        return this;
    }

    public List<WebElement> checkNotFound() {
        return driver.findElements(divNotFound);
    }




}
