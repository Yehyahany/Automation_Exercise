package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08_ContactUsPage {
    private final WebDriver driver;
    private By name = By.name("name");
    private By email = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[3]/form/div[2]/input");
    private By subject = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[3]/form/div[3]/input");
    private By message = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[3]/form/div[4]/textarea");
    private By uploadButton = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[3]/form/div[5]/input");
    private String path = "/Users/yehyahany/Downloads/Automation_Exercise/src/test/resources/TestData/testpic.png";
    private By submitButton = By.name("submit");
    private By homeButton = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[3]/a/span/i");
    private By successMessage = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]");


    public P08_ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    public P08_ContactUsPage enterName (String nametxt){
        Utility.sendData(driver,name,nametxt);
        return this;
    }
    public P08_ContactUsPage enterEmail (String emailtxt){
        Utility.sendData(driver,email,emailtxt);
        return this;
    }
    public P08_ContactUsPage entersubject (String subjecttxt){
        Utility.sendData(driver,subject,subjecttxt);
        return this;
    }
    public P08_ContactUsPage entermessage (String messagetxt){
        Utility.sendData(driver,message,messagetxt);
        return this;
    }
    public P08_ContactUsPage clickOnUpload(){
        Utility.sendData(driver,uploadButton,path);
        return this;
    }
    public P08_ContactUsPage clickOnSubmit(){
        Utility.clickOnElement(driver,submitButton);
        return this;
    }
    public P08_ContactUsPage clickOnOkAlertButton(){
        driver.switchTo().alert().accept();
        return this;
    }
    public String getSuccessMessage(){
        return Utility.GetText(driver,successMessage);
    }

    public P07_HomePage clickOnHomeButton(){
        Utility.clickOnElement(driver,homeButton);
        return new P07_HomePage(driver);
    }


}
