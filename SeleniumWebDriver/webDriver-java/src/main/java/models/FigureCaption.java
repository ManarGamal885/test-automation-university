package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Represents a figure caption element on a webpage and provides methods
 * to interact with its components, such as header text, link, and visibility state.
 *
 * Responsibilities:
 * - Encapsulates elements within a figure caption such as a header and a hyperlink.
 * - Provides methods to retrieve and validate these elements.
 *
 * Constructor:
 * - Initializes the `FigureCaption` class with a WebElement instance representing the caption.
 *
 * Methods:
 * - `checkCaptionDisplayed()`: Checks if the caption element is displayed on the page.
 * - `getHeader()`: Retrieves the header text of the caption element.
 * - `getLink()`: Retrieves the hyperlink URL associated with the caption.
 * - `getLinkText()`: Retrieves the text of the hyperlink within the caption.
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
