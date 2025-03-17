package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Nested Frames Page of the application, providing methods
 * to interact with nested frames and retrieve their content.
 *
 * Responsibilities:
 * - Handles switching between frames on the page, including top, bottom, and left frames.
 * - Provides functionality to fetch text content within a specific frame.
 *
 * Constructor:
 * - Initializes the NestedFramesPage with a WebDriver instance that allows
 *   interaction with the frames and their elements.
 *
 * Methods:
 * - `switchToBottomFrame()`: Switches the WebDriver context to the bottom frame.
 * - `switchToLeftFrame()`: Switches the WebDriver context to the left frame,
 *   first navigating through the top frame.
 * - `getFrameText()`: Retrieves the text content within the currently active frame.
 */
public class NestedFramesPage {
    private final WebDriver driver;
    public final By topFrame = By.name("frame-top");
    public final By leftFrame = By.name("frame-left");
    public final By bottomFrame = By.name("frame-bottom");
    public final By frameBodyText = By.xpath("//body");

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    public void switchToBottomFrame(){
        // Reset to the main document first to avoid frame context issues
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(bottomFrame));
    }

    public void switchToLeftFrame(){
        // Reset to the main document first to avoid frame context issues
        driver.switchTo().defaultContent();
        // First switch to the top frame
        driver.switchTo().frame(driver.findElement(topFrame));
        // Then switch to the left frame
        driver.switchTo().frame(driver.findElement(leftFrame));
    }

    public String getFrameText(){
        return driver.findElement(frameBodyText).getText();
    }
}