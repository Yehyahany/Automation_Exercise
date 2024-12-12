package TestCase1;

import Pages.P01_LoginPage;
import Pages.P02_SignupPage;
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

public class TC02_SignUpTest {
    private WebDriver driver;
    private String NAME = new Faker().name().firstName();
    private String EMAIL = new Faker().internet().emailAddress();

    @BeforeMethod
    public void Setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtils.getPropertyValue("Environments","Home_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void SignupPageTest() throws IOException {

        new P01_LoginPage(driver).clickOnSignuphome();
        new P02_SignupPage(driver).entername(NAME).enteremail(EMAIL).clickOnSignup();
        Assert.assertEquals(driver.getCurrentUrl(),DataUtils.getPropertyValue("Environments","Signup_URL"));
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
