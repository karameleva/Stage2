package webdriver.hurtMePlentyAndHardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdriver.hurtMePlentyAndHardcore.page.*;

public class HardcoreTest {
    private WebDriver driver;
    CalculatorResultsPage resultsPage;
    TenMinuteMailPage tenMinuteMailPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        resultsPage = new CalculatorResultsPage(driver);
        tenMinuteMailPage = new TenMinuteMailPage(driver);
        driver.manage().window().maximize();
        new MainGoogleCloudPage(driver)
                .openPage()
                .makeSearchRequest()
                .selectRequiredPageInSearchResults()
                .activateComputeEngineSection()
                .fillInTheForm();
    }

    @Test
    public void testArePricesOnWebsiteAndInEmailEqual(){
        String priceFromCalculatorPage = resultsPage.getPrice();
        resultsPage.sendEmail(tenMinuteMailPage.getTenMinMail());
        Assert.assertTrue(priceFromCalculatorPage.contains(tenMinuteMailPage.getPrice()), "Prices on the website and in the email are not equal");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}