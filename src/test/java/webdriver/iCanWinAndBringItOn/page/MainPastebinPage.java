package webdriver.iCanWinAndBringItOn.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPastebinPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement textFieldToInsertCode;

    @FindBy(xpath = "//span[@class='select2-selection__rendered']")
    private WebElement btnToChooseSyntaxHighlighting;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement btnBash;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement btnToChoosePasteExpiration;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement btnTenMin;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement textFieldToPasteName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnToSubmitNewPaste;

    public MainPastebinPage(WebDriver driver){
        super(driver);
    }

    public MainPastebinPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(btnToSubmitNewPaste));
        return this;
    }

    public MainPastebinPage inputData(String codeText, String title){
        textFieldToInsertCode.sendKeys(codeText);
        btnToChooseSyntaxHighlighting.click();
        btnBash.click();
        btnToChoosePasteExpiration.click();
        btnTenMin.click();
        textFieldToPasteName.sendKeys(title);
        return this;
    }

    public NewPastebinPage createNewPaste(){
        btnToSubmitNewPaste.click();
        return new NewPastebinPage(driver);
    }
}