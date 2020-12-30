package webdriver.iCanWinAndBringItOn.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webdriver.iCanWinAndBringItOn.page.MainPastebinPage;
import webdriver.iCanWinAndBringItOn.page.NewPastebinPage;

public class BringItOnTest {

    private WebDriver driver;

    private String codeText = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String title = "how to gain dominance among developers" ;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void browserPageNameIsEqualTitle(){
        NewPastebinPage newPage = new MainPastebinPage(driver)
                .openPage()
                .inputData(codeText, title)
                .createNewPaste();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(newPage.getPageTitle(), title,  "Name of the page and Paste Name are not equal");
        softAssert.assertEquals(newPage.getCodeText(), codeText, "Text in new paste and entered text are not equal");
        softAssert.assertEquals(newPage.getTypeOfSyntaxHighlighting(), "bash", "Syntax Highlighting is not equal with 'bash'");
        softAssert.assertAll();
    }

    @AfterMethod (alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver=null;
    }
}