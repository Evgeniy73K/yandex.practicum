import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderPage;

public class OrderPageTest  extends Settings{
    @Test
    public void newOrderTest(){
        OrderPage orderPage;
        mainPage = new MainPage(driver);
        mainPage.acceptCooke();
        orderPage = mainPage.clickOrderPage();
        orderPage.orderScooter("Иван", "Иванов", "улица тестовая");
        Assert.assertTrue(!orderPage.check());
    }

    @Test
    public void emptyField(){
        OrderPage orderPage;
        mainPage = new MainPage(driver);
        mainPage.acceptCooke();
        orderPage = mainPage.clickOrderPage();
        orderPage.orderScooter();
        Assert.assertTrue(
                orderPage.getErrorName().contains("Введите корректное имя")&&
                        orderPage.getErrorLastName().contains("Введите корректную фамилию")&&
                        orderPage.getErrorMetro().contains("Выберите станцию")&&
                        orderPage.getErrorPhone().contains("Введите корректный номер")
        );
    }


}
