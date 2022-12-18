package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) { super(driver); }

    private WebElement getEmptyCartButton() {
        By emptyCartLocator = By.cssSelector(".emptyCartButton");
        wait.until(ExpectedConditions.elementToBeClickable(emptyCartLocator));
        return driver.findElement(emptyCartLocator);
    }
    private WebElement getConfirmEmptyCart() {
        By confirmEmptyCartLocator = By.xpath("//button[text()='Empty']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmEmptyCartLocator));
        return driver.findElement(confirmEmptyCartLocator);
    }
    private WebElement getCartText() {
        By cartTextLocator = By.cssSelector(".header-1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTextLocator));
        return driver.findElement(cartTextLocator);
    }

    public void emptyCart() {
        getEmptyCartButton().click();
        getConfirmEmptyCart().click();
        String expectedText = "Your cart is empty.";
        Assert.assertEquals(expectedText, getCartText().getText());
    }
}
