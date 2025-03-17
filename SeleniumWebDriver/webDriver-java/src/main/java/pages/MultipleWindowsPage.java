package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Multiple Windows page, which allows navigation to new browser windows
 * through specific link interactions.
 *
 * Responsibilities:
 * - Provides functionality to click on a link that opens a new window.
 * - Encapsulates the interaction with the "Click Here" link.
 *
 * Constructor:
 * - Initializes the MultipleWindowsPage with a WebDriver instance for interacting with web elements.
 *
 * Methods:
 * - `clickHereLink()`: Clicks on the "Click Here" link to open a new browser window.
 */
public class MultipleWindowsPage {
    private final WebDriver driver;
    private final By clickHereLink = By.linkText("Click Here");

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHereLink() {
        driver.findElement(clickHereLink).click();
    }
}
