package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_SignupDataPage {
    private final WebDriver driver;
    private final By mgender = By.id("id_gender1");
    private final By name = By.id("name");
    private final By password = By.id("password");
    private final By Fname = By.id("first_name");
    private final By Lname = By.id("last_name");
    private final By address = By.id("address1");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobilenumber = By.id("mobile_number");
    private final By createaccbutton = By.className("btn-default");

    public P03_SignupDataPage(WebDriver driver) {
        this.driver = driver;
    }
    public P03_SignupDataPage selectgender(){
        Utility.clickOnElement(driver,mgender);
        return this;
    }
    public P03_SignupDataPage enterinfo(String nametxt,String passtxt,String firstname,String lastname,String Add,String statetxt,String citytxt,String ziptxt,String mnum){
        Utility.sendData(driver,name,nametxt);
        Utility.sendData(driver,password,passtxt);
        Utility.sendData(driver,Fname,firstname);
        Utility.sendData(driver,Lname,lastname);
        Utility.sendData(driver,address,Add);
        Utility.sendData(driver,state,statetxt);
        Utility.sendData(driver,city,citytxt);
        Utility.sendData(driver,zipcode,ziptxt);
        Utility.sendData(driver,mobilenumber,mnum);
        return this;
    }
    public P04_LandingPage clickOnCreateAcc(){
        Utility.clickOnElement(driver,createaccbutton);
        return new P04_LandingPage(driver);
    }
}
