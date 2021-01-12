package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class DemoTest extends BaseUiTest {

    @Test
    public void rozetkaFirstProductInBinTest(){
        driver.get("https://rozetka.com.ua/");

        driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);

        wait.until(presenceOfElementLocated(By.cssSelector("div.goods-tile img")));
        driver.findElement(By.cssSelector("div.goods-tile img")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("span.var-options__label_color_gray")));
        scrollToElement(driver.findElement(By.cssSelector("span.var-options__label_color_gray")));
        WebElement buyButton = driver.findElement(By.xpath("//*[@class='toOrder']/button"));
        buyButton.click();

        wait.until(presenceOfElementLocated(By.xpath("//a[contains(@class,'cart-receipt__submit')]")));
        WebElement createOrderButton = driver.findElement(By.xpath("//a[contains(@class,'cart-receipt__submit')]"));
        scrollToElement(createOrderButton);
        createOrderButton.click();

        driver.navigate().back();

        WebElement binCounter = driver.findElement(By.cssSelector("span.header-actions__button-counter"));
        assertEquals(binCounter.getText(), "1");
    }

}
