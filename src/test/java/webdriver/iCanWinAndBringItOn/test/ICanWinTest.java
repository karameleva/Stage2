package webdriver.iCanWinAndBringItOn.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdriver.iCanWinAndBringItOn.page.MainPastebinPage;

public class ICanWinTest {

    private WebDriver driver;
    private String codeText = "Hello from WebDriver";
    private String title = "helloWeb";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPaste(){
        new MainPastebinPage(driver)
                .openPage()
                .inputData(codeText, title)
                .createNewPaste();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver=null;
    }
}