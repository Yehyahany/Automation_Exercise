package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P11_ProductDetailsPage {
    private final WebDriver driver;
    private By Pname = By.cssSelector("div[class='product-information'] h2");
    private By Pcategory = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    private By Pprice = By.cssSelector("html > body > section > div > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > span > span");
    private By Pavailability = By.xpath("//div[@class='product-information'] //p[2]//b");
    private By Pcondition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b");
    private By Pbrand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/a");

    public P11_ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean Verifynameisvisible(){
        return Utility.findWebElement(driver,Pname).isDisplayed();
    }
    public boolean Verifycategoryisvisible(){
        return Utility.findWebElement(driver,Pcategory).isDisplayed();
    }
    public boolean Verifypriceisvisible(){
        return Utility.findWebElement(driver,Pprice).isDisplayed();
    }
    public boolean Verifyavailabilityisvisible(){
        return Utility.findWebElement(driver,Pavailability).isDisplayed();
    }
    public boolean Verifyconditionisvisible(){
        return Utility.findWebElement(driver,Pcondition).isDisplayed();
    }
    public boolean Verifybrandisvisible(){
        return Utility.findWebElement(driver,Pbrand).isDisplayed();
    }
}
