package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        System.setProperty(
        "webdriver.chrome.driver", "src/main/resources/chromedriver.exe") ;

        // Test # 4. ввод несуществующей даты 29 февраля при бронировании отеля
        // система перекидывает на следующую дату 1 марта 2022

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
        driver.get("https://iglobe.ru");

       // Тест # 1 . Авторизация на сайте iglobe.ru
       // Позитивное тестирование - ввод верного пароля

        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.id("popup_auth_login")).click();
        driver.findElement(By.id("popup_auth_login")).sendKeys("igor_golubev83@mail.ru");
        driver.findElement(By.id("popup_auth_pwd")).click();
       // driver.findElement(By.id("popup_auth_pwd")).sendKeys("grenada63");
       // driver.findElement(By.cssSelector(".float-right > input")).click();
       // driver.findElement(By.cssSelector("table:nth-child(3) tr:nth-child(2)")).click();
        driver.findElement(By.id("popup_auth_pwd")).sendKeys("Praga019");
        driver.findElement(By.cssSelector(".float-right > input")).click();
        driver.findElement(By.xpath ("//a[text()='Выход']")).click();

        // Test # 2. перевод Travel miles
        // негативное тестирование - перевод миль больше, чем есть на счёте
        // позитивное тестирование - перевод миль на счёт валидного значения

        driver.findElement(By.linkText("Travel Miles")).click();
        driver.findElement(By.cssSelector(".tm-navigator-nav-item-icon-52")).click();
        driver.findElement(By.cssSelector(".tm-navigator-nav-item-active")).click();
        driver.findElement(By.linkText("Подробнее")).click();
        driver.findElement(By.id("tmbanner_13")).click();
        driver.findElement(By.linkText("Авторизируйтесь")).click();
        driver.findElement(By.id("popup_auth_login")).click();
        driver.findElement(By.id("popup_auth_login")).click();
        driver.findElement(By.id("popup_auth_login")).sendKeys("igor_golubev83@mail.ru");
        driver.findElement(By.id("popup_auth_pwd")).click();
        driver.findElement(By.id("popup_auth_pwd")).sendKeys("Praga019");
        driver.findElement(By.cssSelector(".float-right > input")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        driver.findElement(By.id("tmbanner_13")).click();
        driver.findElement(By.id("tm-amt")).click();
        driver.findElement(By.id("tm-amt")).sendKeys("16000");
        driver.findElement(By.cssSelector(".btn > input")).click();
        driver.findElement(By.id("tm-amt")).click();
        driver.findElement(By.id("tm-amt")).sendKeys("100");
        driver.findElement(By.cssSelector(".cabinet_cards-travelmiles-send")).click();
        driver.findElement(By.cssSelector(".btn > input")).click();

        // Test # 3. ввод валидных значений при поиске перелета

        driver.findElement(By.linkText("Главная")).click();
        driver.findElement(By.id("LikeBtn_idate")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.linkText("2")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("#io_dest_block #LikeBtn_idate")).click();
        driver.switchTo().frame(0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        driver.findElement(By.linkText("9")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("rooms_cnt")).click();
        driver.findElement(By.id("room_ADT[0]")).click();
        driver.findElement(By.id("room_CHD[0]")).click();
        //driver.findElement(By.id("room_CHD_ages[0][1]")).click();
        driver.findElement(By.cssSelector(".image")).click();

        // Test # 4. проверка валидных дат при бронировании отеля

       driver.findElement(By.linkText("Отели")).click();
       driver.findElement(By.linkText("Главная")).click();
       driver.findElement(By.id("out_date")).click();
       //driver.findElement(By.id("out_date")).sendKeys("16.02.2022");
      // driver.findElement(By.cssSelector("#io_dest_block #LikeBtn_idate")).click();
       //driver.switchTo().frame(0);
       //driver.findElement(By.linkText("28")).click();
      // driver.switchTo().defaultContent();
      // driver.findElement(By.id("out_date")).click();
       driver.findElement(By.id("out_date")).sendKeys("29.02.2022");
       driver.findElement(By.id("io_destination")).click();
       driver.quit();
                {
        }
    }
}