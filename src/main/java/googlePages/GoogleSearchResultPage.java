package googlePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class GoogleSearchResultPage {

    WebDriver webDriver;
    WebDriverWait wait;

    By statistics = By.cssSelector("#result-stats");
    By searchResultLinks = By.cssSelector("div cite");
    By nextButton = By.xpath("//span[contains(text(),'Next')]");

    public GoogleSearchResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }

    public void waitForStatistics() {
        wait.until(presenceOfElementLocated(statistics));
    }

    private List<WebElement> getAllLinksFromSearchResult() {
        return webDriver.findElements(searchResultLinks);
    }

    private void clickNextButton() {
        webDriver.findElement(nextButton).click();
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
