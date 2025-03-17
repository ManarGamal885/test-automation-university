package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The DynamicLoadingPage class represents the "Dynamic Loading" page of the application.
 *
 * Responsibilities:
 * - Encapsulates elements and interactions available on the dynamic loading page.
 * - Provides functionality to navigate to a dynamically loaded element page through
 *   a specific link.
 *
 * Constructor:
 * - Initializes the DynamicLoadingPage with a WebDriver instance for interacting with web elements.
 *
 * Methods:
 * - `clickExample1Link()`: Clicks on the link to navigate to the dynamically loaded element page
 *   and returns an instance of the DynamicallyLoadedExample class.
 */
public class DynamicLoadingPage {
    private final WebDriver driver;
    public final By linkExample2 = By.xpath("//*[@id=\"content\"]/div/a[2]");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public DynamicallyLoadedExample clickExample1Link(){
        return clickLink(linkExample2);
    }

    private DynamicallyLoadedExample clickLink(By linkText){
        driver.findElement(linkText).click();
        return new DynamicallyLoadedExample(driver);
    }
}
