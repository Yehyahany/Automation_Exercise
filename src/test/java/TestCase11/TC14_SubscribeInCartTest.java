package TestCase11;

import Pages.P01_LoginPage;
import Pages.P12_CartPage;
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

public class TC14_SubscribeInCartTest {
    private WebDriver driver;
    private String EMAIL = new Faker().internet().emailAddress();

    @BeforeMethod
    public void Setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtils.getPropertyValue("Environments","Home_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void OpenCartTest() throws IOException {

        new P01_LoginPage(driver).openCartPage().subscribe(EMAIL);
        Assert.assertTrue(new P12_CartPage(driver).verifysubsuccess());
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
