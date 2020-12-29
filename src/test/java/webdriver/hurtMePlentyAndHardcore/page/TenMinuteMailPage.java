package webdriver.hurtMePlentyAndHardcore.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenMinuteMailPage extends Page {

    @FindBy(id="mail_address")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[@id='mail_messages_content']//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement openEmail;

    @FindBy(xpath = "//*[@id='mobilepadding']//h3[contains(text(), 'USD')]")
    private WebElement price;

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    public String getTenMinMail(){
        open10MinMail();
        waitForPresenceOfElement(mailAddress);
        String newEmail;
        do{
            newEmail = mailAddress.getAttribute("value");
        }
        while (newEmail=="");
        driver.switchTo().window(getHandles().get(0));
        return newEmail;
    }

    public String getPrice(){
        driver.switchTo().window(getHandles().get(1));
        waitElementToBeClickable(openEmail).click();
        String priceInEmail = waitForPresenceOfElement(price).getText();
        return priceInEmail;
    }

    public TenMinuteMailPage open10MinMail(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        driver.switchTo().window(getHandles().get(1));
        driver.get("https://10minutemail.com/");
        return this;
    }
}