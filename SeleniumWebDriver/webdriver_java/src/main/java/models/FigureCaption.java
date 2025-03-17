package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Represents the caption associated with a figure element in a web page.
 *
 * Responsibilities:
 * - Encapsulates the behavior and attributes of a figure caption.
 * - Provides methods to interact with and retrieve information from the caption.
 *
 * Constructor:
 * - Initializes the `FigureCaption` instance with a specific web element representing the caption.
 *
 * Methods:
 * - `checkCaptionDisplayed()`: Verifies if the caption element is displayed.
 * - `getHeader()`: Retrieves the text of the header within the caption.
 * - `getLink()`: Retrieves the URL of the link element contained in the caption.
 * - `getLinkText()`: Prints the text content of the link element in the caption to the console.
 */
public class FigureCaption {

    public WebElement caption;
    public By header = By.tagName("h5");
    public By link = By.tagName("a");

    public FigureCaption(WebElement caption) {
        this.caption = caption;
    }

    public boolean checkCaptionDisplayed(){
        return caption.isDisplayed();
    }

    public String getHeader(){
        return caption.findElement(header).getText();
    }

    public String getLink(){
        return caption.findElement(link).getAttribute("href");
    }

    public String getLinkText(){
        return caption.findElement(link).getText();
    }
}
