package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static java.lang.Thread.sleep;


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) { super(driver); }

    private WebElement getEmptyCartButton() { return driver.findElement(By.cssSelector(".emptyCartButton")); }

    private WebElement getEmptyButton() {
        By emptyButtonLocator = By.xpath("//button[text()='Empty']");
        wait.until(ExpectedConditions.elementToBeClickable(emptyButtonLocator));
        return driver.findElement(emptyButtonLocator);
    }

//    private WebElement getCartText() { return driver.findElement(By.cssSelector(".header-1")); }
    private WebElement getCartText() {
        By cartTextLocator = By.cssSelector(".header-1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTextLocator));
        return driver.findElement(cartTextLocator);
    }
    public void emptyCart() throws InterruptedException {
        getEmptyCartButton().click();
        getEmptyButton().click();
        String expectedText = "Your cart is empty.";
        System.out.println(expectedText);
        System.out.println(getCartText().getText());
//        sleep(3000);
        Assert.assertEquals(expectedText, getCartText().getText());

    }

}
