package webdriver.hurtMePlentyAndHardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdriver.hurtMePlentyAndHardcore.page.*;

public class HurtMePlentyTest {
    private WebDriver driver;
    private CalculatorResultsPage resultsPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        resultsPage = new CalculatorResultsPage(driver);
        driver.manage().window().maximize();
        new MainGoogleCloudPage(driver)
                .openPage()
                .makeSearchRequest()
                .selectRequiredPageInSearchResults()
                .activateComputeEngineSection()
                .fillInTheForm();
    }

    @Test
    public void testIsVMClassEqualExpected(){
        Assert.assertTrue(resultsPage.getVMClass().toLowerCase().contains("regular"), "Expected VM class and expected are not equal");
    }

    @Test
    public void testIsInstanceTypeEqualExpected(){
        Assert.assertTrue(resultsPage.getInstanceType().toLowerCase().contains("n1-standard-8"),"Expected instance type and expected are not equal");
    }

    @Test
    public void testIsRegionEqualExpected(){
        Assert.assertTrue(resultsPage.getRegion().toLowerCase().contains("frankfurt"), "Expected region and expected are not equal");
    }

    @Test
    public void testIsLocalSSDEqualExpected(){
        Assert.assertTrue(resultsPage.getLocalSSD().contains("2x375"), "Expected local SSD and expected are not equal");
    }

    @Test
    public void testIsCommitmentTermEqualExpected(){
        Assert.assertTrue(resultsPage.getCommitmentTerm().toLowerCase().contains("1 year"), "Expected commitment term and expected are not equal");
    }

    @Test
    public void testIsPriceEqualExpected(){
        Assert.assertTrue(resultsPage.getPrice().contains("USD 1,082.77 per 1 month"), "Expected price and expected are not equal");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver=null;
    }
}