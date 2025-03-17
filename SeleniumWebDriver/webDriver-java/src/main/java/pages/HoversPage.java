package pages;

import models.FigureCaption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Represents the Hovers page of the application, allowing interactions
 * with hoverable images and their respective captions.
 *
 * Responsibilities:
 * - Facilitates hovering over specific images on the page.
 * - Provides functionality to retrieve the corresponding caption details
 *   of the hovered image through the FigureCaption class.
 *
 * Constructor:
 * - Initializes the HoversPage with a WebDriver instance for web element interactions.
 *
 * Methods:
 * - `hoverOverImage(int index)`: Hovers over a specific image based on its index
 *   and returns an instance of the FigureCaption class representing the associated caption.
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
