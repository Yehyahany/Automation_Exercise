package TestCase9;

import Pages.P01_LoginPage;
import Pages.P10_ProductsPage;
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

public class TC12_SearchTest {
    private WebDriver driver;

    @BeforeMethod
    public void Setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtils.getPropertyValue("Environments","Home_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void SearchTest() throws IOException {

        new P01_LoginPage(driver).clickOnProductsButton().searchforProduct("Blue").clickOnSearchButton();

        Assert.assertTrue(new P10_ProductsPage(driver).verify());
    }

    @AfterMethod
    public void quit(){
        //driver.quit();
    }
}
