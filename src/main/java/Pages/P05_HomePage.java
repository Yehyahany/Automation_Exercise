package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_HomePage {
    private final By deleteacc = By.xpath("//*[.=' Delete Account']");
    private final WebDriver driver ;


    public P05_HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnDeleteAcc(){
        Utility.clickOnElement(driver,deleteacc);
    }
}
