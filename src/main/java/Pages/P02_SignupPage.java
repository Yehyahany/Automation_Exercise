package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_SignupPage {
    private final WebDriver driver;
    private final By name = By.name("name");
    private final By email = By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]");
    private final By signupbutton = By.xpath("//*[.='Signup']");

    public P02_SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public P02_SignupPage entername(String nametext){
        Utility.sendData(driver,name,nametext);
        return this;
    }
    public P02_SignupPage enteremail(String emailtext){
        Utility.sendData(driver,email,emailtext);
        return this;
    }
    public P03_SignupDataPage clickOnSignup(){
        Utility.clickOnElement(driver,signupbutton);
        return new P03_SignupDataPage(driver);
    }
}
