package ui.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.BaseUiTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class LoginLogoutTest extends BaseUiTest {

    String guruUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String login = "1303";
    String password = "Guru99";
    String negativeAuthorizationAlertText = "User or Password is not valid";
    String positiveAuthorizationAlertText = "You Have Succesfully Logged Out!!";

    @BeforeMethod
    public void startUp(){
        driver.get(guruUrl);
    }

    @Test
    public void positiveLoginLogoutTest(){
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();

        driver.manage().window().fullscreen();
        WebElement logoutButton = wait.until(presenceOfElementLocated(By.xpath("//a[@href='Logout.php']")));
        logoutButton.click();

        assertEquals(driver.switchTo().alert().getText(), positiveAuthorizationAlertText);
        driver.switchTo().alert().accept();

        assertEquals(driver.getCurrentUrl(), guruUrl);
        wait.until(presenceOfElementLocated(By.name("btnLogin")));
    }

    @Test
    public void negativeLoginWrongPasswordTest(){
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
        driver.findElement(By.name("btnLogin")).click();

        assertEquals(driver.switchTo().alert().getText(), negativeAuthorizationAlertText);
        driver.switchTo().alert().accept();

        assertEquals(driver.getCurrentUrl(), guruUrl);
        wait.until(presenceOfElementLocated(By.name("btnLogin")));
    }

    @Test
    public void negativeLoginWrongLoginTest(){
        driver.findElement(By.name("uid")).sendKeys("qwerty");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();

        assertEquals(driver.switchTo().alert().getText(), negativeAuthorizationAlertText);
        driver.switchTo().alert().accept();

        assertEquals(driver.getCurrentUrl(), guruUrl);
        wait.until(presenceOfElementLocated(By.name("btnLogin")));
    }
}
