package webdriver.iCanWinAndBringItOn.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdriver.iCanWinAndBringItOn.page.MainPastebinPage;
import webdriver.iCanWinAndBringItOn.page.NewPastebinPage;

public class BringItOnTest {

    private WebDriver driver;
    private NewPastebinPage newPage;
    private String codeText = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String title = "how to gain dominance among developers" ;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        newPage = new NewPastebinPage(driver);
        driver.manage().window().maximize();
        new MainPastebinPage(driver)
                .openPage()
                .inputData(codeText, title)
                .createNewPaste();
    }

    @Test
    public void browserPageNameIsEqualTitle(){
        Assert.assertEquals(newPage.getPageTitle(), title,  "Name of the page and Paste Name are not equal");
    }

    @Test
    public void codeIsEqualCodeText(){
        Assert.assertEquals(newPage.getCodeText(), codeText, "Text in new paste and entered text are not equal");
    }

    @Test
    public void syntaxHighlightingIsEqualBash(){
        Assert.assertEquals(newPage.getTypeOfSyntaxHighlighting(), "bash", "Syntax Highlighting is not equal with 'bash'");
    }

    @AfterMethod (alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver=null;
    }
}