package webdriver.hurtMePlentyAndHardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends Page {

    @FindBy(xpath = "//div[@class='gsc-resultsbox-visible']")
    private WebElement searchResults;

    @FindBy(linkText = searchRequest)
    private WebElement linkWithRequiredSearchResult;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage selectRequiredPageInSearchResults(){
        waitForPresenceOfElement(searchResults);
        linkWithRequiredSearchResult.click();
        return new CalculatorPage(driver);
    }
}