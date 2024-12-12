package TestCase10;

import Pages.P01_LoginPage;
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

public class TC13_SubscribeTest {
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
    public void SubscribeTest() throws IOException {

        new P01_LoginPage(driver).subscribe(EMAIL);

        Assert.assertTrue(new P01_LoginPage(driver).verifysubsuccess());
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
