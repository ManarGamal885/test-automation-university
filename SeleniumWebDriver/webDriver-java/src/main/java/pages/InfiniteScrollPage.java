package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Infinite Scroll page of the application, which dynamically
 * loads additional content as the user scrolls to the bottom of the page.
 *
 * Responsibilities:
 * - Handles interaction with the infinite scrolling functionality.
 * - Provides a method to scroll until a specific paragraph is loaded.
 * - Facilitates the retrieval of the current count of dynamically loaded paragraphs.
 *
 * Constructor:
 * - Initializes the InfiniteScrollPage with a WebDriver instance for interacting with web elements.
 *
 * Methods:
 * - `scrollToParagraph(int index)`: Scrolls incrementally down the page until the specified
 *   number of paragraphs are loaded.
 * - `getNumberOfParagraphsPresent()`: Retrieves and returns the count of paragraphs currently loaded on the page.
 */
public class InfiniteScrollPage {
    private final WebDriver driver;
    private final By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        while (getNumberOfParagraphsPresent() < index) {
            ((JavascriptExecutor) driver).executeScript(script);
        }
    }

    public int getNumberOfParagraphsPresent() {
        return driver.findElements(textBlocks).size();
    }
}
