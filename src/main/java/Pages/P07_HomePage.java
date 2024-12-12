package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_HomePage {
    private final By logoutbutton = By.xpath("//*[.=' Logout']");
    private WebDriver driver;

    public P07_HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void clickOnLogout(){
        Utility.clickOnElement(driver,logoutbutton);
    }
}
