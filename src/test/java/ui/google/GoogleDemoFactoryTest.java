package ui.google;

import googleFactoryPages.GoogleHomeFactoryPage;
import googleFactoryPages.GoogleSearchResultFactoryPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.BaseUiTest;

public class GoogleDemoFactoryTest extends BaseUiTest {
    private int maxPageNumber = 5;
    private String textForSearchRequest = "iphone kyiv buy";
    private String expectedText = "stylus.ua";
    private String baseUrl = "https://google.com/ncr";
    GoogleHomeFactoryPage googleHomePage;
    GoogleSearchResultFactoryPage googleSearchResultPage;

    @AfterSuite
    public void quiteBrowser() {
        driver.quit();
    }

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(baseUrl);
        googleHomePage = new GoogleHomeFactoryPage(driver);
        googleSearchResultPage = new GoogleSearchResultFactoryPage(driver);
    }

    @Test
    public void googleDemoTest() throws Exception {
        googleHomePage.performSearchRequest(textForSearchRequest);
        googleSearchResultPage.waitForStatistics();
        googleSearchResultPage.searchLinksOnNPages(maxPageNumber, expectedText);
    }
}

