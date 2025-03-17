package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the DropDown page of the application.
 *
 * Responsibilities:
 * - Facilitates interactions with the dropdown element.
 * - Provides methods to select options from the dropdown and retrieve the selected options.
 *
 * Constructor:
 * - Initializes the DropDownPage with a WebDriver instance for interacting with web elements.
 *
 * Methods:
 * - `selectFromDropDown(String option)`: Selects an option from the dropdown by its visible text.
 * - `getSelectedOption()`: Retrieves and returns a list of text values of the selected options in the dropdown.
 */
public class DropDownPage {
    private final WebDriver driver;
    public final By dropDownOption = By.id("dropdown");

    public DropDownPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromDropDown(String option){
        findDropDown().selectByVisibleText(option);
    }

    public List<String> getSelectedOption(){
        List<WebElement> selectedElements = findDropDown().getAllSelectedOptions();
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private Select findDropDown(){
        return new Select(driver.findElement(dropDownOption));
    }
}
