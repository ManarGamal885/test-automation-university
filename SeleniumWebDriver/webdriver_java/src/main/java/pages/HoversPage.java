package pages;

import models.FigureCaption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * HoversPage represents the "Hovers" page of the application, facilitating interactions
 * with elements on the page where hovering actions are required.
 *
 * Responsibilities:
 * - Locate and interact with hoverable elements and their captions.
 * - Provide functionality to perform hover actions and retrieve associated captions.
 *
 * Constructor:
 * - Initializes the HoversPage with a WebDriver instance for interacting with elements.
 *
 * Methods:
 * - `hoverOverImage(int index)`: Simulates a hover action over a specified image based on the given
 *   index and retrieves the associated caption as a FigureCaption instance.
 */
public class HoversPage {
    private final WebDriver driver;
    public final By hoverImages = By.className("figure");
    public final By hoverImageCaption = By.className("figcaption");

    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    public FigureCaption hoverOverImage(int index){

        WebElement hoverImage = driver.findElements(hoverImages).get(index - 1);

        Actions action = new Actions(driver);

        action.moveToElement(hoverImage).perform();

        return new FigureCaption(hoverImage.findElement(hoverImageCaption));
    }
}
