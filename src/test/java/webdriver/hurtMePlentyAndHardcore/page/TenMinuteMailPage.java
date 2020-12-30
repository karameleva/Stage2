package webdriver.hurtMePlentyAndHardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenMinuteMailPage extends AbstractPage {

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
        driver.get("https://10minutemail.com/");
        waitForPresenceOfElement(mailAddress);
        String newEmail;
        do{
            newEmail = mailAddress.getAttribute("value");
        }
        while (newEmail=="");

        return newEmail;
    }

    public String getPrice(){
        waitElementToBeClickable(openEmail).click();
        String priceInEmail = waitForPresenceOfElement(price).getText();
        return priceInEmail;
    }
}