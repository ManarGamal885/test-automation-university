package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Secure Area of the application, providing functionality
 * for interacting with its elements after successful login.
 *
 * Responsibilities:
 * - Allows retrieval of the text from the status alert, which usually provides
 *   feedback on the login action or other secure area-related events.
 * - Facilitates logging out from the secure area, navigating the user back to the Login Page.
 *
 * Constructor:
 * - Initializes the SecureArea with a WebDriver instance to interact with web elements in the secure area.
 *
 * Methods:
 * - `checkStatusAlert()`: Retrieves and returns the text of the status alert element, providing feedback about current events or actions.
 * - `clickLogOutButton()`: Clicks the logout button, logging the user out and returning an instance of the LoginPage.
 */
public class SecureArea {
    private final WebDriver driver;

    private final By statusAlert = By.xpath("//*[@id=\"flash\"]");
    private final By logOutButton = By.xpath("//*[@id=\"content\"]/div/a");

    public SecureArea(WebDriver driver) {
        this.driver = driver;
    }

    public String checkStatusAlert() {
        String n = driver.findElement(statusAlert).getText();
        return driver.findElement(statusAlert).getText();
    }

    public LoginPage clickLogOutButton() {
        driver.findElement(logOutButton).click();
        return new LoginPage(driver);
    }
}
