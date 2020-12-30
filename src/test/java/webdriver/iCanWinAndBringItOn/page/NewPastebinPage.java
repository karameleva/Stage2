package webdriver.iCanWinAndBringItOn.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPastebinPage extends AbstractPage {
     @FindBy(xpath = "//div[@class='notice -success -post-view']")
     private WebElement newPasteIsVisible;

     @FindBy(xpath = "//*[@class = 'textarea']")
     private WebElement textFieldWithCodeText;

     @FindBy(xpath = "//div/ol")
     private WebElement syntaxElement;

     public NewPastebinPage(WebDriver driver) {
          super(driver);
     }

     public String getPageTitle(){
          new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                  .until(ExpectedConditions.visibilityOf(newPasteIsVisible));
          return driver.getTitle();
     }

     public String getCodeText(){
          new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                  .until(ExpectedConditions.visibilityOf(newPasteIsVisible));
          return textFieldWithCodeText.getText();
     }

     public String getTypeOfSyntaxHighlighting(){
          new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                  .until(ExpectedConditions.visibilityOf(newPasteIsVisible));
          return syntaxElement.getAttribute("class");
     }
}