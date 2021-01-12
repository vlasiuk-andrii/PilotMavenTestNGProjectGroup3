package googleFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GoogleSearchResultFactoryPage {

    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(css = "#result-stats")
    private WebElement statistics;
    @FindBy(css = "div cite")
    private List<WebElement> searchResultLinks;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    private WebElement nextButton;

    public GoogleSearchResultFactoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    public void waitForStatistics() {
        wait.until(visibilityOf(statistics));
    }

    private List<WebElement> getAllLinksFromSearchResult() {
        return searchResultLinks;
    }

    private void clickNextButton(){
        nextButton.click();
    }

    public void searchLinksOnNPages(int maxPageNumber, String expectedText) throws Exception {
        for (int i = 1; i <= maxPageNumber; i++) {
            List<WebElement> searchResults = getAllLinksFromSearchResult();
            for (WebElement elem : searchResults) {
                if (elem.getText().contains(expectedText)) {
                    System.out.println("[" + expectedText + "] was found on page number " + i);
                    return;
                }
            }
            clickNextButton();
            if (maxPageNumber == i){
                throw new Exception("[" + expectedText + "] was NOT found on " + maxPageNumber + " pages");
            }
        }
    }
}
