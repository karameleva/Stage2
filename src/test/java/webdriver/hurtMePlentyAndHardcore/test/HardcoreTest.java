package webdriver.hurtMePlentyAndHardcore.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdriver.hurtMePlentyAndHardcore.page.*;

import java.util.ArrayList;
import java.util.List;

public class HardcoreTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testArePricesOnWebsiteAndInEmailEqual(){
        String searchRequest = "Google Cloud Platform Pricing Calculator";
        CalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .makeSearchRequest(searchRequest)
                .selectRequiredPageInSearchResults(searchRequest)
                .activateComputeEngineSection()
                .fillInTheForm();

        String priceFromCalculatorPage = calculatorPage.getPrice();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(handles.get(1));
        TenMinuteMailPage tenMinuteMailPage = new TenMinuteMailPage(driver);
        String tenMinMail = tenMinuteMailPage.getTenMinMail();

        driver.switchTo().window(handles.get(0));
        calculatorPage.sendEmail(tenMinMail);

        driver.switchTo().window(handles.get(1));

        Assert.assertTrue(priceFromCalculatorPage.contains(tenMinuteMailPage.getPrice()), "Prices at the website and in the email are not equal");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}