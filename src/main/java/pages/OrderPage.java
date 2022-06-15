package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    By nameField = By.xpath("//input[@placeholder=\"* Имя\"]");
    By lastNameField = By.xpath("//input[@placeholder=\"* Фамилия\"]");
    By addressField = By.xpath("//input[@placeholder=\"* Адрес: куда привезти заказ\"]");
    By metroField = By.xpath("//input[@placeholder=\"* Станция метро\"]");
    By phoneField = By.xpath("//input[@placeholder=\"* Телефон: на него позвонит курьер\"]");
    By errorNameField = By.xpath("//input[@placeholder=\"* Имя\"]/following::div");
    By errorLastNameField = By.xpath("//input[@placeholder=\"* Фамилия\"]/following::div");
    By errorMetroField = By.xpath("//input[@placeholder=\"* Станция метро\"]/following::div");
    By errorPhoneField = By.xpath("//input[@placeholder=\"* Телефон: на него позвонит курьер\"]/following::div");
    By nextButton = By.xpath("//button[text()=\"Далее\"]");
    By dateField = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");
    By rentField = By.xpath("//div[@class=\"Dropdown-control\"]");
    By dropdownOption = By.xpath("//div[@class=\"Dropdown-option\"]");
    By checkBox = By.xpath("//input[@id=\"black\"]");
    By orderButton = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");
    By yesButton = By.xpath("//button[text()=\"Да\"]");
    By selectDate = By.xpath("//div[@tabindex=\"-1\"]");
    By h1 = By.xpath("//div[text()=\"Хотите оформить заказ?\"]");
    By scooterLogo = By.xpath("//a[@class=\"Header_LogoScooter__3lsAR\"]");

    public OrderPage orderScooter(String name, String lastname, String address) {
        Actions action = new Actions(driver);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(lastname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).click();
        action.moveByOffset(500, 500).click().build().perform();
        driver.findElement(phoneField).sendKeys("+79051234455");
        driver.findElement(nextButton).click();
        driver.findElement(dateField).click();
        driver.findElement(selectDate).click();
        driver.findElement(rentField).click();
        driver.findElement(dropdownOption).click();
        driver.findElement(checkBox).click();
        driver.findElement(orderButton).click();
        driver.findElement(yesButton).click();
        return this;
    }

    public OrderPage orderScooter() {
        driver.findElement(orderButton).click();
        return this;
    }

    public Boolean check(){
        return driver.findElement(h1).isDisplayed();
    }

    public String redirectMainPage(){
        driver.findElement(scooterLogo).click();
        return driver.getCurrentUrl();
    }

    public String getErrorName() {
        return driver.findElement(errorNameField).getText();
    }

    public String getErrorLastName() {
        return driver.findElement(errorLastNameField).getText();
    }

    public String getErrorPhone() {
        return driver.findElement(errorPhoneField).getText();
    }

    public String getErrorMetro() {

        return driver.findElement(errorMetroField).getText();
    }
}
