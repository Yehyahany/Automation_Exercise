package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P10_ProductsPage {
    private final WebDriver driver;
    private final By firstproduct = By.cssSelector("a[href='/product_details/1']");
    private final By searchtxtBox = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By text = By.tagName("body");
    private final String exptxt = "SEARCHED PRODUCTS";

    public P10_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    public P11_ProductDetailsPage clickOnFirstProduct(){
        Utility.scrolling(driver,firstproduct);
        Utility.clickOnElement(driver,firstproduct);
        return new P11_ProductDetailsPage(driver);
    }
    public P10_ProductsPage searchforProduct(String search){
        Utility.sendData(driver,searchtxtBox,search);
        return this;
    }
    public boolean verify(){
        return Utility.findWebElement(driver,text).getText().contains(exptxt);
    }
    public P10_ProductsPage clickOnSearchButton(){
        Utility.clickOnElement(driver,searchButton);
        return this;
    }
}
