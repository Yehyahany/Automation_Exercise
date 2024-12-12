package TestCase5;

import Pages.P01_LoginPage;
import Pages.P02_SignupPage;
import Utilities.DataUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC08_ExistingEmailTest {
    private WebDriver driver;

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
        new P02_SignupPage(driver).entername(DataUtils.getJsonData("validLogin","name")).enteremail(DataUtils.getJsonData("validLogin","email")).clickOnSignup();
        Assert.assertEquals(driver.getCurrentUrl(),DataUtils.getPropertyValue("Environments","Signup_URL"));
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
