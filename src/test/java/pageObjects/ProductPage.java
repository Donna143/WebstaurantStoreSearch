package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) { super(driver); }

    private WebElement getAddToCartButton() { return driver.findElement(By.id("buyButton")); }
    private WebElement getViewCartButton() {
        By viewCartLocator = By.id("cartItemCountSpan");
        wait.until(ExpectedConditions.textToBe(viewCartLocator,"1"));
        return driver.findElement(viewCartLocator);
    }

    public void addToCart() {
        getAddToCartButton().click();
    }

    public void viewCart() {
        getViewCartButton().click();
    }
}
