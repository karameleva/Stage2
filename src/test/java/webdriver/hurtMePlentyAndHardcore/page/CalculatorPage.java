package webdriver.hurtMePlentyAndHardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage  extends AbstractPage {

    @FindBy(xpath = "//*[@id='cloud-site']//iframe")
    private WebElement frameMain;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement frameCalculator;
    
    @FindBy(xpath="//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngine;

    @FindBy(name = "quantity")
    private WebElement numberOfInstances;

    @FindBy(id = "select_76")
    private WebElement selectOperatingSystem;

    @FindBy(xpath = "//md-option[@value='free']")
    private WebElement requiredOperatingSystem;

    @FindBy(id="select_80")
    private WebElement vmClass;

    @FindBy(xpath = "//div[@id='select_container_81'] //md-option[@value='regular']")
    private WebElement regularVMClass;

    @FindBy(id="select_88")
    private WebElement selectSeries;

    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement seriesN1;

    @FindBy(id="select_value_label_60")
    private WebElement selectInstanceType;

    @FindBy(id="select_option_360")
    private WebElement n1Standard8;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement checkBoxAddGPUs;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;

    @FindBy(id="select_option_399")
    private WebElement getNumberOfGPUsOne;

    @FindBy(id="select_396")
    private WebElement gpuType;

    @FindBy(id="select_option_406")
    private WebElement gpuTypeNvidaTeslaV100;

    @FindBy(id="select_355")
    private WebElement localSSD;

    @FindBy(id="select_option_381")
    private WebElement localSSD2x375Gb;

    @FindBy(id="select_92")
    private WebElement datacenterLocation;

    @FindBy(id="select_option_205")
    private WebElement locationFrankfurt;

    @FindBy(id="select_99")
    private WebElement committedUsage;

    @FindBy(id="select_option_97")
    private WebElement committedUsageOneYear;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

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

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage goToFrame(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameMain));
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameCalculator));
        return this;
    }

    public CalculatorPage activateComputeEngineSection(){
        goToFrame();
        waitForPresenceOfElement(computeEngine).click();
        return this;
    }

    public CalculatorPage fillInTheForm(){
        setNumberOfInstances();
        setOperatingSystem();
        setVMClass();
        setInstanceType();
        setGPUs();
        setLocalSSD();
        setDatacenterLocation();
        setCommittedUsage();
        addToEstimate();
        return this;
    }

    private CalculatorPage setNumberOfInstances(){
        waitForPresenceOfElement(numberOfInstances).sendKeys("4");
        return this;
    }

    private CalculatorPage setOperatingSystem(){
        waitForPresenceOfElement(selectOperatingSystem).click();
        waitForPresenceOfElement(requiredOperatingSystem).click();
        return this;
    }

    private CalculatorPage setVMClass(){
        waitForPresenceOfElement(vmClass).click();
        waitForPresenceOfElement(regularVMClass).click();
        return this;
    }

    private CalculatorPage setInstanceType(){
        waitForPresenceOfElement(selectSeries).click();
        waitForPresenceOfElement(seriesN1).click();
        waitForPresenceOfElement(selectInstanceType).click();
        waitForPresenceOfElement(n1Standard8).click();
        return this;
    }

    private CalculatorPage setGPUs(){
        waitForPresenceOfElement(checkBoxAddGPUs).click();
        waitForPresenceOfElement(numberOfGPUs).click();
        waitForPresenceOfElement(getNumberOfGPUsOne).click();
        waitForPresenceOfElement(gpuType).click();
        waitForPresenceOfElement(gpuTypeNvidaTeslaV100).click();
        return this;
    }

    private CalculatorPage setLocalSSD(){
        waitForPresenceOfElement(localSSD).click();
        waitForPresenceOfElement(localSSD2x375Gb).click();
        return this;
    }

    private CalculatorPage setDatacenterLocation(){
        waitForPresenceOfElement(datacenterLocation).click();
        waitForPresenceOfElement(locationFrankfurt).click();
        return this;
    }

    private CalculatorPage setCommittedUsage(){
        waitForPresenceOfElement(committedUsage).click();
        waitForPresenceOfElement(committedUsageOneYear).click();
        return this;
    }

    private CalculatorPage addToEstimate(){
        waitForPresenceOfElement(addToEstimate).click();
        return this;
    }

    public void sendEmail(String tenMinEmail){
        enterEmail(tenMinEmail);
        clickSendEmail();
    }

    public CalculatorPage enterEmail(String mail){
        goToFrame();
        emailEstimate.click();
        waitForPresenceOfElement(email).sendKeys(mail);
        return this;
    }

    public void clickSendEmail(){
        waitElementToBeClickable(sendEmail);
        sendEmail.click();
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
}