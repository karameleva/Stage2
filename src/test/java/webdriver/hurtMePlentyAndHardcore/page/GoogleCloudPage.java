package webdriver.hurtMePlentyAndHardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    @FindBy(xpath = "//div[@class='gsc-resultsbox-visible']")
    private WebElement searchResults;

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPage openPage(){
        driver.get(HOMEPAGE_URL);
        waitElementToBeClickable(search);
        return this;
    }

    public GoogleCloudPage makeSearchRequest(String searchRequest){
        search.click();
        search.sendKeys(searchRequest + "\n");
        return this;
    }

    public CalculatorPage selectRequiredPageInSearchResults(String searchRequest){
        waitForPresenceOfElement(searchResults);
        driver.findElement(By.linkText(searchRequest)).click();
        return new CalculatorPage(driver);
    }
}