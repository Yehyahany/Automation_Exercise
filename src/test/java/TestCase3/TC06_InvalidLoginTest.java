package TestCase3;

import Pages.P06_ExistingUserLogin;
import Utilities.DataUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC06_InvalidLoginTest {
    private WebDriver driver;
    @BeforeMethod
    public void Setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtils.getPropertyValue("Environments","Login_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void InValidLoginTest() throws IOException {

        new P06_ExistingUserLogin(driver)
                .entercredentials(DataUtils.getJsonData("InvalidLogin","email"),DataUtils.getJsonData("InvalidLogin","password"))
                .clickOnLogin();
        Assert.assertEquals(driver.getCurrentUrl(),DataUtils.getPropertyValue("Environments","Login_URL"));
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
