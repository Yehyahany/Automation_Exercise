package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P12_CartPage {

    private final WebDriver driver;
    private final By subemail = By.id("susbscribe_email");
    private final By subscribesubmit = By.id("subscribe");
    private final By txt = By.tagName("body");
    String subsuccessmsg = "You have been successfully subscribed!";

    public P12_CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public P12_CartPage subscribe(String email){
        Utility.scrolling(driver,subemail);
        Utility.sendData(driver,subemail,email);
        Utility.clickOnElement(driver,subscribesubmit);
        return this;
    }
    public boolean verifysubsuccess(){
        return Utility.findWebElement(driver,txt).getText().contains(subsuccessmsg);
    }

}
