package ui.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.BaseUiTest;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

public class GoogleSearchTest extends BaseUiTest {

    @BeforeMethod
    public void startUp(){
        driver.get("https://google.com/ncr");
    }

    @Test
    public void testEnterSearch() {
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        WebElement stats = wait.until(presenceOfElementLocated(By.cssSelector("#result-stats")));

        assertTrue(stats.getText().contains("results"));

        WebElement searchBox = driver.findElement(By.xpath("//div/cite"));
        List<WebElement> elements = driver.findElements(By.xpath("//div/cite"));

    }

    @Test
    public void testClickSearch() {
        driver.findElement(By.name("q")).sendKeys("cheese");
        driver.findElement(By.name("btnK")).click();
        WebElement stats = wait.until(presenceOfElementLocated(By.cssSelector("#result-stats")));

        assertTrue(stats.getText().contains("results"));
    }

}
