package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) { super(driver); }

    private WebElement getNextPageButton() { return driver.findElement(By.xpath("//div[@id='paging']//li[@class='inline-block leading-4 align-top rounded-r-md']")); }

//    private WebElement getLastPageButton() { return driver.findElement(By.xpath("//*[contains(@aria-label, 'last page')]")); }
    public void verifySearchResults(String searchQuery) {
        List<WebElement> dynamicElement;
        WebElement lastProduct = null;
        do {
            List<WebElement> description = driver.findElements(By.xpath("//a[@data-testid='itemDescription']"));
            int numProducts = description.size();
            for (WebElement desc : description) {
                String descText = desc.getText();
//                System.out.println(descText);
//                assertTrue(descText.contains(searchQuery), "Product description does not contain: "+searchQuery+". Product: "+descText);
            }
            dynamicElement = driver.findElements(By.xpath("//*[contains(@aria-label, 'last page')]"));
            if (dynamicElement.size() != 0) { getNextPageButton().click(); }
            else {
                lastProduct = description.get(numProducts-1);
                System.out.println(lastProduct);
            }
        }
        while (dynamicElement.size() != 0);
        lastProduct.click();

    }
}
