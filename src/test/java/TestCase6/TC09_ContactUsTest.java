package TestCase6;

import Pages.P01_LoginPage;
import Pages.P08_ContactUsPage;
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

public class TC09_ContactUsTest {
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
    public void ContactUsPageTest() throws IOException {

        new P01_LoginPage(driver).clickOnContactUsButton();
        new P08_ContactUsPage(driver).enterName(NAME).enterEmail(EMAIL).entersubject("abc").entermessage("Hi")
                        .clickOnUpload()
                .clickOnSubmit().
                clickOnOkAlertButton()
                .clickOnHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(),DataUtils.getPropertyValue("Environments","Home_URL"));
    }

    /*@AfterMethod
    public void quit(){
        driver.quit();
    }*/
}
