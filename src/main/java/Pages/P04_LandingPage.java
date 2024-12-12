package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_LandingPage {
    private final WebDriver driver;
    private final By continuebutton = By.className("btn-primary");

    public P04_LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public P05_HomePage clickoncontinueButton(){
        Utility.clickOnElement(driver,continuebutton);
        return new P05_HomePage(driver);
    }
}
