package webdriver.hurtMePlentyAndHardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Page {
    protected WebDriver driver;
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(15);
    protected final String searchRequest = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//*[@id='cloud-site']//iframe")
    private WebElement frameMain;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement frameCalculator;

    protected Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForPresenceOfElement(WebElement element){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement waitElementToBeClickable(WebElement element){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public List<String> getHandles() {
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        return handles;
    }

    public Page goToFrame(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameMain));
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameCalculator));
        return this;
    }
}