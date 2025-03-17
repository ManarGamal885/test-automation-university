package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Horizontal Slider page of the application.
 *
 * Responsibilities:
 * - Facilitates interactions with the horizontal slider control.
 * - Provides methods to adjust the slider value and retrieve the current value.
 *
 * Constructor:
 * - Initializes the HorizontalSliderPage with a WebDriver instance for interacting with web elements.
 *
 * Methods:
 * - `setSliderValue(String value)`: Adjusts the slider to the specified value by incrementing
 *   until the desired value is reached.
 * - `getSliderValue()`: Retrieves and returns the current value of the slider.
 */
public class HorizontalSliderPage {
    private final WebDriver driver;
    public final By slider = By.cssSelector(".sliderContainer input[type=\"range\"]");
    public final By rangeValue = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSliderValue(String value){
        while(!getSliderValue().equals(value)){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue(){
        return driver.findElement(rangeValue).getText();
    }

}
