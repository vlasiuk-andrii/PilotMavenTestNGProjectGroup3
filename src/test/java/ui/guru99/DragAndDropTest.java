package ui.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import ui.BaseUiTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DragAndDropTest extends BaseUiTest {

    @Test
    public void test1(){
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));
        WebElement From2=driver.findElement(By.xpath("//*[@id='credit1']/a"));
        WebElement To2=driver.findElement(By.xpath("//*[@id='loan']/li"));
        WebElement From3=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement To3=driver.findElement(By.xpath("//*[@id='amt7']/li"));
        WebElement From4=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement To4=driver.findElement(By.xpath("//*[@id='amt8']/li"));

        Actions act=new Actions(driver);
        act.dragAndDrop(From1, To1).build().perform();
        act.dragAndDrop(From2, To2).build().perform();
        act.dragAndDrop(From3, To3).build().perform();
        act.dragAndDrop(From4, To4).build().perform();
        assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed(), "Text \"Perfect\" was not displayed");

    }
}
