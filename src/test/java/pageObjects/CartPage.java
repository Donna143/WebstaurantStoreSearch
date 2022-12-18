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
    private WebElement getEmptyButton() {
        By emptyButtonLocator = By.xpath("//button[text()='Empty']");
        wait.until(ExpectedConditions.elementToBeClickable(emptyButtonLocator));
        return driver.findElement(emptyButtonLocator);
    }
    private WebElement getCartText() {
        By cartTextLocator = By.cssSelector(".header-1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTextLocator));
        return driver.findElement(cartTextLocator);
    }
    public void emptyCart() {
        getEmptyCartButton().click();
        getEmptyButton().click();
        String expectedText = "Your cart is empty.";
//        System.out.println(expectedText);
//        System.out.println(getCartText().getText());
        Assert.assertEquals(expectedText, getCartText().getText());

    }

}
