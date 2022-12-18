package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) { super(driver); }

    private WebElement getAddToCartButton() { return driver.findElement(By.id("buyButton")); }
    private WebElement getViewCartButton() {
        By viewCartLocator = By.id("cartItemCountSpan");
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLocator));
        return driver.findElement(viewCartLocator);
    }
    private WebElement getCartCount() { return driver.findElement(By.id("cartItemCountSpan")); }

    public void addToCart() {
        getAddToCartButton().click();
    }

    public void viewCart() {
        getViewCartButton().click();
        String expectedCount = "1";
//        System.out.println(expectedCount);
//        System.out.println(getCartCount().getText());
        Assert.assertEquals(expectedCount, getCartCount().getText());
    }
}
