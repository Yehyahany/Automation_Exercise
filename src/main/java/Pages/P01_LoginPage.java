package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {

    private final By loginbutton = By.xpath("//*[.=' Signup / Login']");
    private final By contactusbutton = By.xpath("//*[.=' Contact us']");
    private final By testcasesButton = By.xpath("//a[@href='/test_cases']");
    private final By productsButton = By.className("material-icons");
    private final By cartButton = By.className("fa-shopping-cart");
    private final By subemail = By.id("susbscribe_email");
    private final By subscribesubmit = By.id("subscribe");
    private final By txt = By.tagName("body");
    String subsuccessmsg = "You have been successfully subscribed!";
    private final WebDriver driver ;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public P02_SignupPage clickOnSignuphome(){
        Utility.clickOnElement(driver,loginbutton);
        return new P02_SignupPage(driver);
    }
    public P08_ContactUsPage clickOnContactUsButton(){
        Utility.clickOnElement(driver,contactusbutton);
        return new P08_ContactUsPage(driver);
    }
    public void clickOnTestcasesButton(){
        Utility.clickOnElement(driver,testcasesButton);
    }
    public P10_ProductsPage clickOnProductsButton(){
        Utility.clickOnElement(driver,productsButton);
        return new P10_ProductsPage(driver);
    }
    public P01_LoginPage subscribe(String email){
        Utility.scrolling(driver,subemail);
        Utility.sendData(driver,subemail,email);
        Utility.clickOnElement(driver,subscribesubmit);
        return this;
    }
    public P12_CartPage openCartPage(){
        Utility.clickOnElement(driver,cartButton);
        return new P12_CartPage(driver);
    }
    public boolean verifysubsuccess(){
        return Utility.findWebElement(driver,txt).getText().contains(subsuccessmsg);
    }
}
