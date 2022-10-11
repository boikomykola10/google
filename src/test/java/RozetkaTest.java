import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RozetkaTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void testRozetka() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header" +
                "/rz-main-header/header/div/div/div/form/div/div/input"));
        searchInput.click();
        searchInput.sendKeys("Mac");
        WebElement searchBtn = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header" +
                "/header/div/div/div/form/button"));
        searchBtn.click();

        WebElement firstProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='goods-tile__heading')]")));

        List<WebElement> macMiniProduct = driver.findElements(By.xpath("//span[contains(text(), 'Mac mini')]"));

        for(WebElement e: macMiniProduct) {
            String title = e.getText();
            System.out.println(title);
        }



    }
    @AfterMethod
    public void after() {
        //driver.quit();
    }

}