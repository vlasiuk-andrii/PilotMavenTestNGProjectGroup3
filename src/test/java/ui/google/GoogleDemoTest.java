package ui.google;

import googlePages.GoogleHomePage;
import googlePages.GoogleSearchResultPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.BaseUiTest;

public class GoogleDemoTest extends BaseUiTest {
    private int maxPageNumber = 5;
    private String textForSearchRequest = "iphone kyiv buy";
    private String expectedText = "stylus.ua";
    private String baseUrl = "https://google.com/ncr";
    GoogleHomePage googleHomePage;
    GoogleSearchResultPage googleSearchResultPage;

    @AfterSuite
    public void quiteBrowser() {
        driver.quit();
    }

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(baseUrl);
        googleHomePage = new GoogleHomePage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
    }

    @Test
    public void googleDemoTest() throws Exception {
        googleHomePage.performSearchRequest(textForSearchRequest);
        googleSearchResultPage.waitForStatistics();
        googleSearchResultPage.searchLinksOnNPages(maxPageNumber, expectedText);
    }
}

