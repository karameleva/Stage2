package webdriver.hurtMePlentyAndHardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainGoogleCloudPage extends Page {

    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    public MainGoogleCloudPage(WebDriver driver) {
        super(driver);
    }

    public MainGoogleCloudPage openPage(){
        driver.get(HOMEPAGE_URL);
        waitElementToBeClickable(search);
        return this;
    }

    public SearchResultsPage makeSearchRequest(){
        search.click();
        search.sendKeys(searchRequest + "\n");
        return new SearchResultsPage(driver);
    }
}