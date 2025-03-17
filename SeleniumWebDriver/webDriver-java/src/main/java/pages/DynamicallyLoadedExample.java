package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The DynamicallyLoadedExample class represents a page with dynamically loaded elements.
 * It provides methods to interact with these elements, specifically a start button,
 * a loading bar, and text that appears after loading is complete.
 *
 * Constructor:
 * - Initializes the DynamicallyLoadedExample with a WebDriver instance for element interactions.
 *
 * Methods:
 * - `getTheLoadingText()`: Retrieves and returns the text displayed after loading is complete.
 * - `getTheLoadingBar()`: Finds and returns the WebElement representing the loading bar.
 * - `clickStartButton()`: Clicks the start button, waits for the loading bar to disappear,
 *   and ensures the page has fully loaded dynamically.
 */
public class DynamicallyLoadedExample {
    private final WebDriver driver;
    public final By startButton = By.cssSelector("#start button");
    public final By loadingBar = By.id("loading");
    public final By loadingText = By.id("finish");

    public DynamicallyLoadedExample(WebDriver driver){
        this.driver = driver;
    }

    public String getTheLoadingText(){
        return driver.findElement(loadingText).getText();
    }

    public WebElement getTheLoadingBar(){
        return driver.findElement(loadingBar);
    }

    public void clickStartButton(){
        clickLink(startButton);
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(getTheLoadingBar()));

        // Using the fluent wait method

        //        FluentWait fluentWait = new FluentWait(driver);
        //        fluentWait.withTimeout(java.time.Duration.ofSeconds(5))
        //                .pollingEvery(java.time.Duration.ofMillis(1))
        //                .ignoring(NoSuchElementException.class);
        //
        //        wait.until(ExpectedConditions.invisibilityOf(getTheLoadingBar()));

        // Allows me to wait for a page to load
        //        driver.manage().timeouts().pageLoadTimeout()

        // Allows me to wait for async script to finish
        //        driver.manage().timeouts().setScriptTimeout()

    }

    private void clickLink(By linkText){
        driver.findElement(linkText).click();
    }
}
