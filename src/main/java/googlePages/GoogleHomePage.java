package googlePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

    WebDriver webDriver;

    By searchInput = By.xpath("//input[@name='q']");

    public GoogleHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void performSearchRequest(String text) {
        webDriver.findElement(searchInput).sendKeys(text + Keys.ENTER);
    }
}
