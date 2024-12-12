package TestCase1;

import Pages.P01_LoginPage;
import Utilities.DataUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC01_LoginTest {
    private WebDriver driver;
    private final String HomeURL = "https://automationexercise.com";
    private final String LoginURL = "https://automationexercise.com/login";

    @BeforeMethod
    public void Setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtils.getPropertyValue("Environments","Home_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void LoginPageTest() throws IOException {

        new P01_LoginPage(driver).clickOnSignuphome();
        Assert.assertEquals(DataUtils.getPropertyValue("Environments","Login_URL"),driver.getCurrentUrl());
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
