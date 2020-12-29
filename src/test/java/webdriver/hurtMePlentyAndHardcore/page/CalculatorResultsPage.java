package webdriver.hurtMePlentyAndHardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorResultsPage extends Page{

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(), 'VM class')]")
    private WebElement resultVMClass;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(), 'Instance type')]")
    private WebElement resultInstanceType;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(), 'Region')]")
    private WebElement resultRegion;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(), 'local SSD')]")
    private WebElement resultLocalSSD;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(), 'Commitment term')]")
    private WebElement resultCommitmentTerm;

    @FindBy(xpath="//*[@id='compute']//b[contains(text(), 'Cost')]")
    private WebElement resultPrice;

    @FindBy(id="email_quote")
    private WebElement emailEstimate;

    @FindBy(id="input_477")
    private WebElement email;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmail;

    public CalculatorResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getVMClass(){
        return resultVMClass.getText();
    }

    public String getInstanceType(){
        return resultInstanceType.getText();
    }

    public String getRegion(){
        return resultRegion.getText();
    }

    public String getLocalSSD(){
        return resultLocalSSD.getText();
    }

    public String getCommitmentTerm(){
        return resultCommitmentTerm.getText();
    }

    public String getPrice(){
        return resultPrice.getText();
    }

    public void sendEmail(String tenMinEmail){
        enterEmail(tenMinEmail);
        clickSendEmail();
    }
    public CalculatorResultsPage enterEmail(String mail){
        goToFrame();
        emailEstimate.click();
        waitForPresenceOfElement(email).sendKeys(mail);
        return this;
    }

    public void clickSendEmail(){
        waitElementToBeClickable(sendEmail);
        sendEmail.click();
    }
}