package TestCase8;

import Pages.P01_LoginPage;
import Pages.P11_ProductDetailsPage;
import Utilities.DataUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC11_VerifyAllProductsTest {
    private WebDriver driver;

    @BeforeMethod
    public void Setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtils.getPropertyValue("Environments","Home_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void OpenProductsPageTest() throws IOException {

        new P01_LoginPage(driver).clickOnProductsButton();
        Assert.assertEquals(driver.getCurrentUrl(),DataUtils.getPropertyValue("Environments","Products_URL"));
    }

    @Test
    public void ViewFirstProductTest () throws IOException {
        new P01_LoginPage(driver).clickOnProductsButton().clickOnFirstProduct();
        Assert.assertEquals(driver.getCurrentUrl(),DataUtils.getPropertyValue("Environments","FirstProduct_URL"));
    }
    @Test
    public void ViewFirstProductDetailsTest () throws IOException {
        new P01_LoginPage(driver).clickOnProductsButton().clickOnFirstProduct();
        Assert.assertTrue(new P11_ProductDetailsPage(driver).Verifynameisvisible());
        Assert.assertTrue(new P11_ProductDetailsPage(driver).Verifycategoryisvisible());
        Assert.assertTrue(new P11_ProductDetailsPage(driver).Verifypriceisvisible());
        Assert.assertTrue(new P11_ProductDetailsPage(driver).Verifyconditionisvisible());
        Assert.assertTrue(new P11_ProductDetailsPage(driver).Verifyavailabilityisvisible());
        Assert.assertTrue(new P11_ProductDetailsPage(driver).Verifybrandisvisible());
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
