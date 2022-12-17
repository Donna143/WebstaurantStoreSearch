package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getSearchField(){
        return driver.findElement(By.id("searchval"));
    }
    private WebElement getSearchButton(){
        return driver.findElement(By.cssSelector("[value='Search']"));
    }

    public void open(String url){
        driver.get(url);
    }

    public void productSearch(String product){
        getSearchField().sendKeys(product);
        getSearchButton().click();
    }
}
