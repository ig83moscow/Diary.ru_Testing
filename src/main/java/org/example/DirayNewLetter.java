package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DirayNewLetter {

    public static void main(String[] args) {
        // System.setProperty(
        //         "webdriver.chrome.driver", "src/main/resources/chromedriver.exe") ;

// Test # 2. Создание нового письма
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru");
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.findElement(By.cssSelector(".i-letter")).click();
        driver.findElement(By.linkText("Написать письмо")).click();
        driver.findElement(By.id("page_content")).click();
        driver.findElement(By.id("touser")).click();
        driver.findElement(By.id("touser")).sendKeys("igor.golubev@renault.com");
        driver.findElement(By.id("umailform-title")).click();
        driver.findElement(By.id("umailform-title")).sendKeys("обучение Selenium WD");
        driver.switchTo().frame(5);
        driver.findElement(By.cssSelector("html")).click();
        {
        }
    }
}
