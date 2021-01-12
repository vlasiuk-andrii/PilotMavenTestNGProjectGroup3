package ui.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ui.BaseUiTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class RozetkaBasketTest extends BaseUiTest {

    String searchText = "samsung";

    @Test
    public void basketIconTest(){
        driver.get("http://rozetka.com.ua");
        driver.findElement(By.name("search")).sendKeys(searchText + Keys.ENTER);

        By firstProductBy = By.cssSelector("a.goods-tile__picture");
        wait.until(presenceOfElementLocated(firstProductBy));
        driver.findElement(firstProductBy).click();

        By buyButtonBy = By.cssSelector("button.buy-button.button.button_with_icon");
        wait.until(presenceOfElementLocated(buyButtonBy));
        assertEquals(driver.findElements(By.cssSelector("a>svg+span")).size(), 0);
        scrollToElement(driver.findElement(buyButtonBy));
        driver.findElement(buyButtonBy).click();
        By createOrderBy = By.xpath("//div[@class='cart-receipt']//*[contains(@href,'checkout')]");
        wait.until(presenceOfElementLocated(createOrderBy));
        scrollToElement(driver.findElement(createOrderBy));
        driver.findElement(createOrderBy).click();

        driver.navigate().back();

        assertEquals(driver.findElement(By.cssSelector("a>svg+span")).getText(), "1");
    }
}
