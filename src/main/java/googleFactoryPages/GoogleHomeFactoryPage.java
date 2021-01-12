package googleFactoryPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomeFactoryPage {

    WebDriver webDriver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public GoogleHomeFactoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void performSearchRequest(String text) {
        searchInput.sendKeys(text + Keys.ENTER);
    }
}
