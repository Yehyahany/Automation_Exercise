package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ExistingUserLogin {
    private final By email = By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]");
    private final By pass = By.name("password");
    private final By loginbutton = By.className("btn-default");
    private WebDriver driver;

    public P06_ExistingUserLogin(WebDriver driver) {
        this.driver=driver;
    }

    public P06_ExistingUserLogin entercredentials(String emailtxt,String passtxt){
        Utility.sendData(driver,email,emailtxt);
        Utility.sendData(driver,pass,passtxt);
        return this;
    }
    public P07_HomePage clickOnLogin(){
        Utility.clickOnElement(driver,loginbutton);
        return new P07_HomePage(driver);
    }
}
