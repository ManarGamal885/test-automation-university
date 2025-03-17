package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Represents the Large And Deep DOM page of the application.
 *
 * Responsibilities:
 * - Provides access to the large table element in the DOM.
 * - Facilitates interaction with the page by enabling scrolling to the large table element.
 *
 * Constructor:
 * - Initializes the LargeAndDeepDOMPage with a WebDriver instance for element interactions.
 *
 * Methods:
 * - `getTable()`: Retrieves the WebElement representing the large table on the page.
 * - `scrollToTable()`: Scrolls the page to bring the large table element into view in the DOM.
 */
public class LargeAndDeepDOMPage {
    private final WebDriver driver;
    public final By table = By.id("large-table");

    public LargeAndDeepDOMPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getTable(){
        return driver.findElement(table);
    }

    public void scrollToTable(){

        // This is for elements exists in the dom only but there is another way for elements that are added to the dom consistently
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script ,getTable());
    }
}
