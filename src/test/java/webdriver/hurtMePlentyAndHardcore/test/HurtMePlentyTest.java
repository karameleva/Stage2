package webdriver.hurtMePlentyAndHardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import webdriver.hurtMePlentyAndHardcore.page.*;

public class HurtMePlentyTest {
    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAreEnteredAndPresentDataEqual(){
        String searchRequest = "Google Cloud Platform Pricing Calculator";
        CalculatorPage resultsPage = new GoogleCloudPage(driver)
                .openPage()
                .makeSearchRequest(searchRequest)
                .selectRequiredPageInSearchResults(searchRequest)
                .activateComputeEngineSection()
                .fillInTheForm();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultsPage.getVMClass().toLowerCase().contains("regular"), "Expected VM class and expected are not equal");
        softAssert.assertTrue(resultsPage.getInstanceType().toLowerCase().contains("n1-standard-8"),"Expected instance type and expected are not equal");
        softAssert.assertTrue(resultsPage.getRegion().toLowerCase().contains("frankfurt"), "Expected region and expected are not equal");
        softAssert.assertTrue(resultsPage.getLocalSSD().contains("2x375"), "Expected local SSD and expected are not equal");
        softAssert.assertTrue(resultsPage.getCommitmentTerm().toLowerCase().contains("1 year"), "Expected commitment term and expected are not equal");
        softAssert.assertTrue(resultsPage.getPrice().contains("USD 1,082.77 per 1 month"), "Expected price and expected are not equal");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver=null;
    }
}