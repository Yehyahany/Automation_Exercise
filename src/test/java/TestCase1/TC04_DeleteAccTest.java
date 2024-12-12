package TestCase1;

import Pages.P01_LoginPage;
import Pages.P02_SignupPage;
import Pages.P03_SignupDataPage;
import Pages.P04_LandingPage;
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

public class TC04_DeleteAccTest {
    private WebDriver driver;
    private String NAME = new Faker().name().firstName();
    private String EMAIL = new Faker().internet().emailAddress();
    private String PASS = new Faker().internet().password();
    private String ADDRESS = String.valueOf(new Faker().address());
    private String STATE = String.valueOf(new Faker().country());
    private String CITY = String.valueOf(new Faker().country());
    private String ZIPC = new Faker().number().digits(5);
    private String NUMBER = new Faker().number().digits(10);


    @BeforeMethod
    public void Setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtils.getPropertyValue("Environments","Home_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void DeleteAccountTest() throws IOException {

        new P01_LoginPage(driver).clickOnSignuphome();
        new P02_SignupPage(driver).entername(NAME).enteremail(EMAIL).clickOnSignup();
        new P03_SignupDataPage(driver).selectgender().enterinfo(NAME,PASS,NAME,NAME+"abc",ADDRESS,STATE,CITY,ZIPC,NUMBER)
                .clickOnCreateAcc();
        new P04_LandingPage(driver).clickoncontinueButton().clickOnDeleteAcc();
        Assert.assertEquals(driver.getCurrentUrl(),DataUtils.getPropertyValue("Environments","DeleteAccount_URL"));
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
