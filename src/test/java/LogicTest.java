import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogicTest {

    WebDriver driver;

    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://google.com.ua/");
    }

    @Test
    public void testGoogle() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        WebElement searchBtn = driver.findElement(By.name("btnK"));
        searchInput.sendKeys("qa");

        if (searchBtn.getAttribute("value").equals("Поиск в Google")) {
            searchBtn.submit();
        } else {
            Assert.fail();
        }
    }
    @AfterMethod
    public void after() {
        driver.quit();
    }

}
